package com.example.atividade1

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Patterns
import kotlinx.android.synthetic.main.activity_login.*

class LoginActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        btn_clear.setOnClickListener {
            clearFields()
        }
        btn_signin.setOnClickListener {
            validateLoginField()
            validatePasswordField()
        }
    }

    private fun clearFields() {
        txt_login.text.clear()
        txt_password.text.clear()
    }

    private fun validateLoginField(): Boolean {
        if (txt_login.text.isEmpty()) {
            txt_login.error = getString(R.string.login_error_username_empty)
            return false
        } else if(!Patterns.EMAIL_ADDRESS.matcher(txt_login.text.toString()).matches()) {
            txt_login.error = getString(R.string.login_error_username_invalid)
            return false
        }
        return true
    }

    private fun validatePasswordField(): Boolean {
        if (txt_password.length() < 6) {
            txt_password.error = getString(R.string.login_error_password_length)
            return false
        }
        return true
    }

}
