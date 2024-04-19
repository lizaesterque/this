package com.example.finalexam


import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import com.example.finalexam.databinding.ActivitySignInBinding





class SignInActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySignInBinding
    private lateinit var firebaseAuth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivitySignInBinding.inflate(layoutInflater)
        setContentView(binding.root)

            binding.textSignUp.setOnClickListener{
                val intent = Intent (this@SignInActivity, SignUpActivity::class.java)
                startActivity(intent)

            }

            firebaseAuth = FirebaseAuth.getInstance()

            binding.loginButton.setOnClickListener{
                val email = binding.emailEt.text.toString()
                val pass = binding.passET.text.toString()


                if (email.isNotEmpty() && pass.isNotEmpty()) {

                    firebaseAuth.signInWithEmailAndPassword(email, pass).addOnCompleteListener{
                        if(it.isSuccessful ) {
                            val intent = Intent (this, MainActivity::class.java)
                            startActivity(intent)



                        } else {
                            Toast.makeText(this, it.exception.toString(), Toast.LENGTH_SHORT).show()
                        }
                    }


                } else {
                    Toast.makeText(this, "Empty fields are not Allowed!", Toast.LENGTH_SHORT).show()
                }
            }


            }
        }







