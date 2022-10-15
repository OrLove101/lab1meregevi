package com.orlove101.android.programminglab1orlov

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import kotlin.random.Random

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    override fun onResume() {
        super.onResume()
        findViewById<Button>(R.id.button).setOnClickListener {
            val howMushTimes = findViewById<EditText>(R.id.howMushTimesView).text.toString().toInt()
            val animalId = Random.nextInt(1, 4)
            for (i in 1..howMushTimes) {
                when (animalId) {
                    1 -> {
                        val cat = Cat()
                        cat.eat()
                        cat.speak()
                        cat.walkFast()
                        cat.walkSlow()
                    }
                    2 -> {
                        val dog = Dog()
                        dog.place()
                        dog.speak()
                        dog.walkFast()
                        dog.walkSlow()
                    }
                    3 -> {
                        val bird = Bird()
                        bird.fly()
                        bird.speak()
                        bird.walkFast()
                        bird.walkSlow()
                    }
                    4 -> {
                        val fish = Fish()
                        fish.speak()
                    }
                }
            }
        }
    }
}

abstract class Animal {
     protected abstract val isCanSpeak: Boolean
     abstract val name: String

     abstract fun speak(): String
}

class Cat : Animal(), Walk {
    override val isCanSpeak: Boolean = true
    override val name: String = "Murzik"
    private val age = 4

    override fun speak(): String = if (isCanSpeak) "Myau" else ""
    fun eat() {
        for (i in 1..5) {
            Log.d(TAG, "cat eating some food")
        }
    }

    override fun walkFast() {
        for (i in 1..5) Log.d(TAG, "cat walking fast")
    }

    override fun walkSlow() {
        for (i in 1..5) Log.d(TAG, "cat walking slow")
    }
}

class Dog : Animal(), Walk {
    override val isCanSpeak: Boolean = true
    override val name: String = "Barsik"
    private val mood = "Happy"

    override fun speak() = if (isCanSpeak) "Gav!" else ""
    fun place() {
        for (i in 1..5) Log.d(TAG, "Dog sitting")
    }

    override fun walkFast() {
        for (i in 1..5) Log.d(TAG, "dog walking fast")
    }

    override fun walkSlow() {
        for (i in 1..5) Log.d(TAG, "dog walking slow")
    }
}

class Bird : Animal(), Walk {
    override val isCanSpeak: Boolean = true
    override val name: String = "Petya"
    private val isCanFly = true

    override fun speak() = if (isCanSpeak) "Chick-chirik" else ""
    fun fly() {
        if (isCanFly) Log.d(TAG, "bird flying in the sky!")
    }

    override fun walkFast() {
        for (i in 1..5) Log.d(TAG, "cat walking fast")
    }

    override fun walkSlow() {
        for (i in 1..5) Log.d(TAG, "cat walking slow")
    }
}

class Fish : Animal() {
    override val isCanSpeak: Boolean = false
    override val name: String = "Sparki"

    override fun speak(): String = if (isCanSpeak) "Bul-Bul" else ""
}

interface Walk {
    fun walkFast()
    fun walkSlow()
}

private const val TAG = "MainActivity"