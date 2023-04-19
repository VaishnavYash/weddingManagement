package yash.com.example.weddingManagement

import android.app.DatePickerDialog
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.ImageButton
import androidx.appcompat.app.AppCompatDelegate
import com.google.android.material.textfield.TextInputLayout
import java.text.SimpleDateFormat
import java.util.*

class FirstActivity : AppCompatActivity() {
    private lateinit var datePick : EditText
    private lateinit var firstName : EditText
    private lateinit var lastName : EditText
    private lateinit var emailId : EditText
    private lateinit var emailPass : EditText
    private lateinit var addressText : EditText
    private lateinit var phoneNo : EditText

    private lateinit var textDatePick : TextInputLayout
    private lateinit var textFirstName : TextInputLayout
    private lateinit var textLastName : TextInputLayout
    private lateinit var textEmailId : TextInputLayout
    private lateinit var textEmailPass : TextInputLayout
    private lateinit var textAddressText : TextInputLayout
    private lateinit var textPhoneNo : TextInputLayout

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_first)

        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)

        val maleBtn :ImageButton = findViewById(R.id.male_btn)
        val femaleBtn :ImageButton = findViewById(R.id.female_btn)
        val otherBtn :ImageButton = findViewById(R.id.other_btn)

        datePick  = findViewById(R.id.date_pick)
        firstName = findViewById(R.id.first_name)
        lastName = findViewById(R.id.last_name)
        emailId  = findViewById(R.id.email_id)
        emailPass = findViewById(R.id.email_pass)
        addressText = findViewById(R.id.address)
        phoneNo = findViewById(R.id.phone_number)

        textDatePick  = findViewById(R.id.text_date)
        textFirstName = findViewById(R.id.text_first_name)
        textLastName = findViewById(R.id.text_last_name)
        textEmailId  = findViewById(R.id.text_emailId)
        textEmailPass = findViewById(R.id.text_password)
        textAddressText = findViewById(R.id.text_address)
        textPhoneNo = findViewById(R.id.text_phone)

        var malePress: Boolean = false
        var femalePress: Boolean = false
        var otherPress: Boolean = false

        maleBtn.setOnClickListener {
            if(!malePress){
                if(femalePress){
                    femaleBtn.setBackgroundResource(R.drawable.imagebg)
                    femalePress = false
                }
                if(otherPress){
                    otherBtn.setBackgroundResource(R.drawable.imagebg)
                    otherPress = false
                }
                maleBtn.setBackgroundResource(R.drawable.imagebgblue)
            }else{
                maleBtn.setBackgroundResource(R.drawable.imagebg)
            }
            malePress = !malePress
        }
        femaleBtn.setOnClickListener {
            if(!femalePress){
                if(malePress){
                    maleBtn.setBackgroundResource(R.drawable.imagebg)
                    malePress = false
                }
                if(otherPress){
                    otherBtn.setBackgroundResource(R.drawable.imagebg)
                    otherPress = false
                }
                femaleBtn.setBackgroundResource(R.drawable.imagebgpress)
            }else{
                femaleBtn.setBackgroundResource(R.drawable.imagebg)
            }
            femalePress = !femalePress
        }
        otherBtn.setOnClickListener {
            if(!otherPress){
                if(femalePress){
                    femaleBtn.setBackgroundResource(R.drawable.imagebg)
                    femalePress = false
                }
                if(malePress){
                    maleBtn.setBackgroundResource(R.drawable.imagebg)
                    malePress = false
                }
                otherBtn.setBackgroundResource(R.drawable.imagebgother)
            }else{
                otherBtn.setBackgroundResource(R.drawable.imagebg)
            }
            otherPress = !otherPress
        }

        val calendar = Calendar.getInstance()
        val dateSetListener = DatePickerDialog.OnDateSetListener { _, year, monthOfYear, dayOfMonth ->
            calendar.set(Calendar.YEAR, year)
            calendar.set(Calendar.MONTH, monthOfYear)
            calendar.set(Calendar.DAY_OF_MONTH, dayOfMonth)

            val dateFormat = SimpleDateFormat("dd/MM/yyyy", Locale.getDefault())
            datePick.setText(dateFormat.format(calendar.time))

        }

        datePick.setOnClickListener {
            DatePickerDialog(
                this,
                dateSetListener,
                calendar.get(Calendar.YEAR),
                calendar.get(Calendar.MONTH),
                calendar.get(Calendar.DAY_OF_MONTH)
            ).show()
        }
        textDatePick.setOnClickListener {
            DatePickerDialog(
                this,
                dateSetListener,
                calendar.get(Calendar.YEAR),
                calendar.get(Calendar.MONTH),
                calendar.get(Calendar.DAY_OF_MONTH)
            ).show()
        }

        var submitBtn :Button = findViewById(R.id.nxt_btn)
        submitBtn.setOnClickListener {
            if(!allGood()){
                return@setOnClickListener
            }
            startActivity(Intent(this, HomeActivity::class.java))
            finish()
        }


    }

    private fun allGood(): Boolean {
        if(firstName.text.isEmpty()){
            textFirstName.error = "Please Enter First Name"
            return false
        }else{
            textFirstName.isErrorEnabled=false
        }
        if(lastName.text.isEmpty()){
            textLastName.error = "Please Enter Last Name"
            return false
        }else{
            textLastName.isErrorEnabled=false
        }
        if(phoneNo.text.isEmpty()){
            textPhoneNo.error = "Please Enter Phone Number"
            return false
        }else{
            textPhoneNo.isErrorEnabled=false
        }
        if(emailId.text.isEmpty()){
            textEmailId.error = "Please Enter Email Id"
            return false
        }else{
            textEmailId.isErrorEnabled=false
        }
        if(emailPass.text.isEmpty()){
            textEmailPass.error = "Please Enter Password"
            return false
        }else{
            textEmailPass.isErrorEnabled=false
        }
        if(datePick.text.isEmpty()){
            textDatePick.error = "Please Select Wedding Date"
            return false
        }else{
            textDatePick.isErrorEnabled=false
        }
        if(addressText.text.isEmpty()){
            textAddressText.error = "Address can't be Empty"
            return false
        }else{
            textAddressText.isErrorEnabled=false
        }
        return true
    }

    override fun finish() {
        super.finish()
    }
}