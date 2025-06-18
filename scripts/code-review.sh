#!/bin/bash

# Code Review Script - Run ktlint analysis locally
# Usage: ./scripts/code-review.sh [branch-name]

set -e

# Colors for output
RED='\033[0;31m'
GREEN='\033[0;32m'
YELLOW='\033[1;33m'
BLUE='\033[0;34m'
NC='\033[0m' # No Color

echo -e "${BLUE}🤖 Local Code Review Analysis${NC}"
echo "================================="

# Get the branch to compare against (default to main)
TARGET_BRANCH=${1:-main}
echo -e "Comparing against branch: ${YELLOW}$TARGET_BRANCH${NC}"

# Check if we're in a git repository
if ! git rev-parse --git-dir > /dev/null 2>&1; then
    echo -e "${RED}❌ Error: Not in a git repository${NC}"
    exit 1
fi

# Get list of changed Kotlin files
echo -e "\n${BLUE}📁 Analyzing changed files...${NC}"
CHANGED_FILES=$(git diff --name-only $TARGET_BRANCH...HEAD | grep -E '\.kt$' || true)

if [ -z "$CHANGED_FILES" ]; then
    echo -e "${GREEN}✅ No Kotlin files changed${NC}"
    exit 0
fi

echo -e "Changed Kotlin files:"
echo "$CHANGED_FILES" | while read file; do
    echo -e "  - ${YELLOW}$file${NC}"
done

# Run ktlint check
echo -e "\n${BLUE}🔍 Running ktlint analysis...${NC}"
./gradlew ktlintCheck --continue > ktlint-output.tmp 2>&1 || true

# Analyze results for changed files
TOTAL_ISSUES=0
echo -e "\n${BLUE}📊 Analysis Results:${NC}"
echo "$CHANGED_FILES" | while read file; do
    if [ -n "$file" ]; then
        ISSUES=$(grep -c "$file:" ktlint-output.tmp 2>/dev/null || echo "0")
        if [ "$ISSUES" -gt 0 ]; then
            echo -e "  ${RED}❌ $file: $ISSUES issues${NC}"
            TOTAL_ISSUES=$((TOTAL_ISSUES + ISSUES))
        else
            echo -e "  ${GREEN}✅ $file: Clean${NC}"
        fi
    fi
done

# Show detailed issues if any
if grep -q "\.kt:" ktlint-output.tmp; then
    echo -e "\n${YELLOW}⚠️  Detailed Issues:${NC}"
    echo "$CHANGED_FILES" | while read file; do
        if [ -n "$file" ]; then
            FILE_ISSUES=$(grep "$file:" ktlint-output.tmp || true)
            if [ -n "$FILE_ISSUES" ]; then
                echo -e "\n${YELLOW}📄 $file:${NC}"
                echo "$FILE_ISSUES" | sed 's/^/  /'
            fi
        fi
    done
    
    echo -e "\n${BLUE}🔧 How to fix:${NC}"
    echo "  1. Run: ./gradlew ktlintFormat"
    echo "  2. Review and commit the formatting changes"
    echo "  3. Fix any remaining issues manually"
else
    echo -e "\n${GREEN}🎉 All changed files are clean!${NC}"
fi

# Cleanup
rm -f ktlint-output.tmp

echo -e "\n${BLUE}💡 Pro Tips:${NC}"
echo "  - Set up ktlint formatting in your IDE"
echo "  - Consider adding a pre-commit hook"
echo "  - Use './gradlew ktlintFormat' before committing"

echo -e "\n${GREEN}✅ Code review analysis complete!${NC}"
