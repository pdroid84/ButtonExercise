package com.example.android.buttonexercise;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Switch;
import android.widget.Toast;
import android.widget.ToggleButton;

public class MainActivity extends AppCompatActivity {

    RadioGroup mRadioGroup;
    ToggleButton mToggleButton;
    Switch mSwitch;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        /******** Toggle Button Section ***********/
        mToggleButton = (ToggleButton) findViewById(R.id.toggle_button);
        mToggleButton.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    Toast.makeText(getBaseContext(), "Toggle Button On", Toast.LENGTH_LONG).show();
                } else {
                    Toast.makeText(getBaseContext(), "Toggle Button Off", Toast.LENGTH_LONG).show();
                }
            }
        });

        /******** Switch Button Section ***********/
        mSwitch = (Switch) findViewById(R.id.switch_button);
        mSwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    Toast.makeText(getBaseContext(),"Switch Button On",Toast.LENGTH_LONG).show();
                }
                else {
                    Toast.makeText(getBaseContext(),"Switch Button Off",Toast.LENGTH_LONG).show();
                }
            }
        });

        /*************** Radio Button Section *************/
        mRadioGroup = (RadioGroup) findViewById(R.id.radio_button_grp);
        //Clear the radio group selection
        mRadioGroup.clearCheck();

        /* Attach CheckedChangeListener to radio group */
        mRadioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                RadioButton radioButton = (RadioButton) group.findViewById(checkedId);
                if (radioButton != null && checkedId > -1) {
                    Toast.makeText(getBaseContext(), radioButton.getText(), Toast.LENGTH_LONG).show();
                }
            }
        });
    }

    public void onClear (View v) {
        mRadioGroup.clearCheck();
    }

    public void onSubmit (View v) {
        RadioButton radioButton = (RadioButton) findViewById(mRadioGroup.getCheckedRadioButtonId());
        Toast.makeText(getBaseContext(), radioButton.getText(), Toast.LENGTH_LONG).show();
    }
}
