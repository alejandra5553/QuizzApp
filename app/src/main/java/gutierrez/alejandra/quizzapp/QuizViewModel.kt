package gutierrez.alejandra.quizzapp

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel

private const val TAG = "QuizViewModel"
const val CURRENT_INDEX_KEY = "CURRENT_INDEX_KEY"

class QuizViewModel(private val savedStateHandle: SavedStateHandle): ViewModel(){
    private val question = listOf(
        Pregunta(R.string.question_australia, true),
        Pregunta(R.string.question_oceans, true),
        Pregunta(R.string.question_mideast, false),
        Pregunta(R.string.question_africa, false),
        Pregunta(R.string.question_americas, true),
        Pregunta(R.string.question_asia, true)

    )
    private var currentIndex: Int
        get() = savedStateHandle.get(CURRENT_INDEX_KEY) ?: 0
        set(value) = savedStateHandle.set(CURRENT_INDEX_KEY, value)

    val currentQuestionText: Int
        get() = question[currentIndex].textResId

    val currentQuestionAnswer: Boolean
        get() = question[currentIndex].answer

    fun moveToNext() {
        currentIndex = (currentIndex + 1) % question.size
    }

    fun moveToPrevious() {
        currentIndex = (currentIndex - 1) % question.size}


}