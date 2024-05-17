package com.example.motivation.data

import com.example.motivation.infrastructure.MotivationConstants
import kotlin.random.Random

data class Phrase(
    val description: String,
    val categoryId: Int,
    val language: String
)

class Mock {
    private val all = MotivationConstants.FILTER.ALL
    private val profile = MotivationConstants.FILTER.PROFILE
    private val clock = MotivationConstants.FILTER.CLOCK

    private val langPt = MotivationConstants.LANGUAGE.PORTUGUESE
    private val langEn = MotivationConstants.LANGUAGE.ENGLISH
    private val langFr = MotivationConstants.LANGUAGE.FRENCH


    private val listPhrases: List<Phrase> = listOf(
        Phrase("Não sabendo que era impossível, foi lá e fez.", profile, langPt),
        Phrase(
            "Você não é derrotado quando perde, você é derrotado quando desiste!",
            profile,
            langPt
        ),
        Phrase("Quando está mais escuro, vemos mais estrelas!", profile, langPt),
        Phrase(
            "Insanidade é fazer sempre a mesma coisa e esperar um resultado diferente.",
            profile,
            langPt
        ),
        Phrase("Não pare quando estiver cansado, pare quando tiver terminado.", profile, langPt),
        Phrase(
            "O que você pode fazer agora que tem o maior impacto sobre o seu sucesso?",
            profile,
            langPt
        ),
        Phrase("A melhor maneira de prever o futuro é inventá-lo.", clock, langPt),
        Phrase("Você perde todas as chances que você não aproveita.", clock, langPt),
        Phrase("Fracasso é o condimento que dá sabor ao sucesso.", clock, langPt),
        Phrase(" Enquanto não estivermos comprometidos, haverá hesitação!", clock, langPt),
        Phrase("Se você não sabe onde quer ir, qualquer caminho serve.", clock, langPt),
        Phrase("Se você acredita, faz toda a diferença.", clock, langPt),
        Phrase(
            "Riscos devem ser corridos, porque o maior perigo é não arriscar nada!",
            clock,
            langPt
        ),
        Phrase("Not knowing it was impossible, he went there and did it.", profile, langEn),
        Phrase(
            "You are not defeated when you lose, you are defeated when you give up!",
            profile,
            langEn
        ),
        Phrase("When it's darker, we see more stars!", profile, langEn),
        Phrase(
            "Insanity is always doing the same thing and expecting a different result.",
            profile,
            langEn
        ),
        Phrase("Don't stop when you're tired, stop when you're done.", profile, langEn),
        Phrase("What can you do now that has the biggest impact on your success?", profile, langEn),
        Phrase("The best way to predict the future is to invent it.", clock, langEn),
        Phrase("You lose every chance you don't take.", clock, langEn),
        Phrase("Failure is the spice that flavors success.", clock, langEn),
        Phrase(" As long as we are not committed, there will be hesitation!", clock, langEn),
        Phrase("If you don't know where you want to go, any way will do.", clock, langEn),
        Phrase("If you believe, it makes all the difference.", clock, langEn),
        Phrase(
            "Risks must be taken, because the greatest danger is not risking anything!",
            clock,
            langEn
        ),
        Phrase("Ne sachant pas que c'était impossible, il y est allé et l'a fait.", profile, langFr),
        Phrase(
            "Tu n'es pas vaincu quand tu perds, tu es vaincu quand tu abandonnes!",
            profile,
            langFr
        ),
        Phrase("Quand il fait plus sombre, on voit plus d'étoiles!", profile, langFr),
        Phrase(
            "La folie, c'est toujours faire la même chose et s'attendre à un résultat différent.",
            profile,
            langFr
        ),
        Phrase("Ne t'arrête pas quand tu es fatigué, arrête quand tu as fini.", profile, langFr),
        Phrase(
            "Que pouvez-vous faire maintenant qui a le plus grand impact sur votre succès?",
            profile,
            langFr
        ),
        Phrase("La meilleure façon de prédire l'avenir est de l'inventer.", clock, langFr),
        Phrase("Vous perdez toutes les chances que vous ne prenez pas.", clock, langFr),
        Phrase("L'échec est l'épice qui parfume le succès.", clock, langFr),
        Phrase("Tant qu'on n'est pas engagé, il y aura des hésitations!", clock, langFr),
        Phrase(
            "Si vous ne savez pas où vous voulez aller, n'importe quoi fera l'affaire.",
            clock,
            langFr
        ),
        Phrase("Si vous croyez, cela fait toute la différence.", clock, langFr),
        Phrase(
            "Il faut prendre des risques, car le plus grand danger est de ne rien risquer!",
            clock,
            langFr
        )
    )

    // Obtém frase aleatória de acordo com o filtro
    fun getPhrase(value: Int, language: String): String {

        // Caso a língua do usuário não esteja entre as disponíveis
        var langFilter = language.lowercase()
        if (language !in listOf(langEn, langPt, langFr)) {
            langFilter = langPt
        }

        val filtered = listPhrases.filter {
            (it.categoryId == value || value == all) && (it.language ==langFilter )
        }
        // Número aleatório de 0 ao tamanho da lista retornada do filtro
        val rand = Random.nextInt(filtered.size)

        // Retorna string
        return filtered[rand].description
    }
}

