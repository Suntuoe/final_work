package com.example.cpc10

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.android.material.textfield.TextInputEditText




class Fragment_1 : Fragment() {


    lateinit var resultTextView: TextView
    lateinit var wordTextInputEditText: TextInputEditText
    lateinit var clearButton: Button
    lateinit var calculateButton: Button

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_1, container, false)
        val en_vowels_latters_list = listOf('A', 'E', 'I', 'O', 'U', 'Y','a','e','i','u','o','y')
        val en_consonants_latters_list = listOf('B', 'C', 'D', 'F', 'G', 'H', 'J', 'K', 'L', 'M', 'N', 'P', 'Q', 'R', 'S', 'T', 'V', 'W', 'X', 'Z','b','c','d','f',
        'g','h','j','k','l','m','n','p','q','r','s','t','v','w','x','z')
        var en_vowels_latters_count: Int
        var en_consonants_latters_count:Int
        var others_letter_count:Int


        resultTextView = view.findViewById(R.id.result_textview)
        wordTextInputEditText = view.findViewById(R.id.wordenter_edittext)
        clearButton = view.findViewById(R.id.clear_button)
        calculateButton = view.findViewById(R.id.calculate_button)

        clearButton.setOnClickListener {
            resultTextView.text = ""
            wordTextInputEditText.setText("")
        }

        calculateButton.setOnClickListener {
            en_vowels_latters_count = 0
            en_consonants_latters_count = 0
            others_letter_count = 0
            var userword = wordTextInputEditText.text.toString()
            for ( i in 0..userword.length-1){
                if (userword[i] in en_vowels_latters_list) {
                    en_vowels_latters_count++
                }
                else if (userword[i] in en_consonants_latters_list) {
                    en_consonants_latters_count++
                }
                else others_letter_count++
            }
            resultTextView.text = "Count of vowels english letters is " + en_vowels_latters_count.toString()+"\n"+
                    "Count of  consonants english letters is " + en_consonants_latters_count.toString()+"\n" +
                    "Count of other symbols is " +  others_letter_count.toString()
        }


        return view
    }


}