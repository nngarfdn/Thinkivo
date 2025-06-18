#!/bin/bash

# Pre-commit hook for ktlint
# Install this hook by copying it to .git/hooks/pre-commit and making it executable
# Or run: cp scripts/pre-commit-hook.sh .git/hooks/pre-commit && chmod +x .git/hooks/pre-commit

set -e

# Colors
RED='\033[0;31m'
GREEN='\033[0;32m'
YELLOW='\033[1;33m'
BLUE='\033[0;34m'
NC='\033[0m'

echo -e "${BLUE}🔍 Running pre-commit ktlint check...${NC}"

# Get list of staged Kotlin files
STAGED_FILES=$(git diff --cached --name-only --diff-filter=ACM | grep -E '\.kt$' || true)

if [ -z "$STAGED_FILES" ]; then
    echo -e "${GREEN}✅ No Kotlin files staged for commit${NC}"
    exit 0
fi

echo -e "Checking staged Kotlin files:"
echo "$STAGED_FILES" | while read file; do
    echo -e "  - ${YELLOW}$file${NC}"
done

# Run ktlint on the project
echo -e "\n${BLUE}Running ktlint...${NC}"
if ./gradlew ktlintCheck --quiet; then
    echo -e "${GREEN}✅ All staged files pass ktlint checks${NC}"
    exit 0
else
    echo -e "${RED}❌ Ktlint issues found in staged files${NC}"
    echo -e "\n${YELLOW}🔧 Auto-fixing issues...${NC}"
    
    # Try to auto-fix
    ./gradlew ktlintFormat --quiet
    
    # Check if files were modified
    MODIFIED_FILES=$(git diff --name-only | grep -E '\.kt$' || true)
    
    if [ -n "$MODIFIED_FILES" ]; then
        echo -e "${YELLOW}⚠️  Some files were auto-formatted:${NC}"
        echo "$MODIFIED_FILES" | while read file; do
            echo -e "  - ${YELLOW}$file${NC}"
        done
        echo -e "\n${BLUE}Please review the changes and add them to your commit:${NC}"
        echo "  git add ."
        echo "  git commit"
        exit 1
    else
        echo -e "${RED}❌ Some issues cannot be auto-fixed${NC}"
        echo -e "Please fix them manually and try again."
        exit 1
    fi
fi
