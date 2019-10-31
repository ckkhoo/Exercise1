package com.example.exercise1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        buttonCalculate.setOnClickListener{
            calculateLoan();
        }
    }

    private fun calculateLoan(){
        //Getting input data from the user
        val price = editTextPrice.text.toString().toInt();
        val downPayment = editTextDownPayment.text.toString().toInt();
        val loanPeriod = editTextLoanPeriod.text.toString().toInt();
        val interestRate = editTextInterestRate.text.toString().toFloat();

        val loan = price - downPayment;
        val interest = loan * interestRate * loanPeriod;
        val monthlyRepayment = (loan + interest) / loanPeriod / 12;

        textViewLoanDisplay.text = getString(R.string.loan) + ": ${loan} ";
        textViewInterestDisplay.text = " " + interest.toString();
        textViewMonthlyRepaymentDisplay.text = " ${monthlyRepayment}";
    }

    fun resetInput(view: View){
        textViewLoanDisplay.text = "";
        textViewInterestDisplay.text = "";
        textViewMonthlyRepaymentDisplay.text = "";
        editTextPrice.text.clear();
        editTextDownPayment.text.clear();
        editTextLoanPeriod.text.clear();
        editTextInterestRate.text.clear();
    }

    /*
    private fun calculateInterest():Float{
        //Getting input data from the user
        val price = editTextPrice.text.toString().toInt();
        val downPayment = editTextDownPayment.text.toString().toInt();
        val loanPeriod = editTextLoanPeriod.text.toString().toInt();
        val interestRate = editTextInterestRate.text.toString().toFloat();

        val interest = calculateLoan() * interestRate * loanPeriod;

        return interest;
    }

    private fun calculateMonthlyRepayment():Float{
        //Getting input data from the user
        val price = editTextPrice.text.toString().toInt();
        val downPayment = editTextDownPayment.text.toString().toInt();
        val loanPeriod = editTextLoanPeriod.text.toString().toInt();
        val interestRate = editTextInterestRate.text.toString().toFloat();

        val monthlyRepayment = (calculateLoan() + calculateInterest()) / loanPeriod / 12;

        return monthlyRepayment;
    }
    */
}
