package org.mob.thinkivo

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform
