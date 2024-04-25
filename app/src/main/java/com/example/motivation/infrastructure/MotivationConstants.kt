package com.example.motivation.infrastructure
/**
 * Chaves usadas pela aplicação
 * Definir em variáveis para remover o risco de digitar incorretamente
 * */
class MotivationConstants private constructor() {
    object KEY {
        const val USER_NAME = "USER_NAME"
    }

    object FILTER {
        const val ALL = 1
        const val PROFILE = 2
        const val CLOCK = 3
    }
}