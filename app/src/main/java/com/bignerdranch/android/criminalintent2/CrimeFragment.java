package com.bignerdranch.android.criminalintent2;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.Editable;
import android.text.TextWatcher;
import android.text.format.DateFormat;
import android.text.format.DateUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;

/**
 * Created by @s.t.o.k.a.t.o on 24.01.2017.
 */

public class CrimeFragment extends Fragment
{
    private Crime mCrime;
    private EditText mTitleField; // виджет - редактируемое текстовое поле
    private Button mDateButton;
    private CheckBox mSolvedCheckBox;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mCrime = new Crime();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, final ViewGroup container, Bundle savedInstanceState) {
        // Представление, его родитель, нужно ли включать заполненное представление в родителя
        // false - потому что представление будет добавлено в коде активности
        View v = inflater.inflate(R.layout.fragment_crime, container, false);

        //---------------------------------------------------------------------
        mTitleField = (EditText)v.findViewById(R.id.crime_title);
        mTitleField.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                mCrime.setTitle(charSequence.toString());
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });

        //-----------------------------------------------------------------------
        mDateButton = (Button)v.findViewById(R.id.crime_date);

        android.text.format.DateFormat df = new android.text.format.DateFormat();
//        mDateButton.setText(mCrime.getDate().toString());

        mDateButton.setText(df.format("MMM dd, yyyy", mCrime.getDate()));
        mDateButton.setEnabled(false);

        //------------------------------------------------------------------------
        mSolvedCheckBox = (CheckBox)v.findViewById(R.id.crime_solved);
        mSolvedCheckBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                mCrime.setSolved(b);
            }
        });

        return v;
    }

}
