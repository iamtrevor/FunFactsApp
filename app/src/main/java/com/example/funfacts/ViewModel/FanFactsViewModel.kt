package com.example.funfacts.ViewModel

import androidx.lifecycle.ViewModel

class FanFactsViewModel : ViewModel() {


    fun getRandomFacts(selectedAnimal : String) : String {
        return if (selectedAnimal == "Dog") {
            getDodFacts().random()
        } else {
            getCatFacts().random()
        }
    }


    fun getDodFacts(): List<String> {
        val dogsFacts = listOf(
            "Dogs have an incredible sense of smell that is estimated to be up to 100,000 times stronger than a human's.",
            "Every dog's nose print is unique, much like a human fingerprint.",
            "Dogs can learn more than 100 words and gestures, and some highly trained dogs can understand over 1,000.",
            "The Basenji breed is often called the \"barkless dog\" because it makes a yodel-like sound instead of a typical bark.",
            "Tail wagging does not always mean a dog is happy; it can also indicate excitement, nervousness, or uncertainty.",
            "The smallest dog ever recorded was a Chihuahua named Miracle Milly, measuring only about 9.65 cm (3.8 inches) tall.",
            "Puppies are born deaf and blind and rely on their sense of touch and smell during their first weeks of life."
        )
        return dogsFacts
    }



    fun getCatFacts(): List<String> {
        val catsFacts = listOf(
            "A group of kittens is called a \"kindle.\"",
            "Cats have over 20 muscles controlling each ear, allowing them to rotate their ears up to 180 degrees.",
            "A cat's nose print is unique, just like a human fingerprint.",
            "The oldest known pet cat lived over 9,000 years ago alongside humans.",
            "The world's richest cat inherited millions of dollars from its owner.",
            "The world's oldest recorded cat lived to be 38 years old.",
            "Cats communicate with humans using meows much more than they do with other cats."
        )
        return catsFacts
    }






}