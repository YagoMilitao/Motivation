package com.example.motivation.data

import com.example.motivation.infrastructure.MotivationConstants
import kotlin.random.Random

data class Phrase(
    val description: String,
    val categoryId: Int
)
class Mock{
    private val all = MotivationConstants.FILTER.ALL
    private val profile = MotivationConstants.FILTER.PROFILE
    private val clock = MotivationConstants.FILTER.CLOCK

    private val mListPhrase = listOf<Phrase>(
        Phrase("Não sabendo que era impossível, foi lá e fez.", profile),
        Phrase("Você não é derrotado quando perde, você é derrotado quando desiste!", profile),
        Phrase("Quando está mais escuro, vemos mais estrelas!", profile),
        Phrase("Insanidade é fazer sempre a mesma coisa e esperar um resultado diferente.", profile),
        Phrase("Não pare quando estiver cansado, pare quando tiver terminado.", profile),
        Phrase("O que você pode fazer agora que tem o maior impacto sobre o seu sucesso?", profile),
        Phrase("A melhor maneira de prever o futuro é inventá-lo.", clock),
        Phrase("Você perde todas as chances que você não aproveita.", clock),
        Phrase("Fracasso é o condimento que dá sabor ao sucesso.", clock),
        Phrase(" Enquanto não estivermos comprometidos, haverá hesitação!", clock),
        Phrase("Se você não sabe onde quer ir, qualquer caminho serve.", clock),
        Phrase("Se você acredita, faz toda a diferença.", clock),
        Phrase("Riscos devem ser corridos, porque o maior perigo é não arriscar nada!", clock)
    )

    // Obtém frase aleatória de acordo com o filtro
    fun  getPhrase(value:Int):String{
      val filtered = mListPhrase.filter{it.categoryId == value || value == all}
        // Número aleatório de 0 ao tamanho da lista retornada do filtro
        val rand = Random.nextInt(filtered.size)

        // Retorna string
        return filtered[rand].description
    }
}

