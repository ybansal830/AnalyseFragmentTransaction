package com.myfirst.analysefragmenttransaction;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button mBtnAddA, mBtnAddB, mBtnRemoveA, mBtnRemoveB, mBtnReplaceAWithBWithBackstack;
    private Button mBtnReplaceAWithBWithoutBackstack, mBtnReplaceBWithA;
    private FragmentManager fragmentManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initViews();
        fragmentManager = getSupportFragmentManager();
    }

    private void initViews() {
        mBtnAddA = findViewById(R.id.btnAddA);
        mBtnAddB = findViewById(R.id.btnAddB);
        mBtnRemoveA = findViewById(R.id.btnRemoveA);
        mBtnRemoveB = findViewById(R.id.btnRemoveB);
        mBtnReplaceAWithBWithBackstack = findViewById(R.id.btnReplaceAWithB);
        mBtnReplaceAWithBWithoutBackstack = findViewById(R.id.btnReplaceAWithBWithoutBackstack);
        mBtnReplaceBWithA = findViewById(R.id.btnReplaceBWithA);
        mBtnAddA.setOnClickListener(this);
        mBtnAddB.setOnClickListener(this);
        mBtnRemoveA.setOnClickListener(this);
        mBtnRemoveB.setOnClickListener(this);
        mBtnReplaceAWithBWithBackstack.setOnClickListener(this);
        mBtnReplaceAWithBWithoutBackstack.setOnClickListener(this);
        mBtnReplaceBWithA.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btnAddA:
                addA();
                break;
            case R.id.btnAddB:
                addB();
                break;
            case R.id.btnRemoveA:
                removeA();
                break;
            case R.id.btnRemoveB:
                removeB();
                break;
            case R.id.btnReplaceAWithB:
                replaceAWithBWithBackStack();
                break;
            case R.id.btnReplaceBWithA:
                replaceBWithA();
                break;
            case R.id.btnReplaceAWithBWithoutBackstack:
                replaceAWithB();
        }
    }

    private void addA() {
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        FragmentA fragmentA = new FragmentA();
        fragmentTransaction.add(R.id.flContainer, fragmentA, "FragmentA").commit();
    }

    private void addB() {
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        FragmentB fragmentB = new FragmentB();
        fragmentTransaction.add(R.id.flContainer, fragmentB, "FragmentB").commit();
    }

    private void removeA() {
        FragmentA fragmentA = (FragmentA)fragmentManager.findFragmentByTag("FragmentA");
        if (fragmentA != null){
            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
            fragmentTransaction.remove(fragmentA).commit();
        }
    }

    private void removeB() {
        FragmentB fragmentB = (FragmentB)fragmentManager.findFragmentByTag("FragmentB");
        if (fragmentB != null){
            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
            fragmentTransaction.remove(fragmentB).commit();
        }
    }

    private void replaceAWithB() {
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        FragmentB fragmentB = new FragmentB();
        fragmentTransaction.replace(R.id.flContainer, fragmentB, "FragmentB").commit();
    }

    private void replaceBWithA() {
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        FragmentA fragmentA = new FragmentA();
        fragmentTransaction.replace(R.id.flContainer, fragmentA, "FragmentA").commit();
    }

    private void replaceAWithBWithBackStack() {
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        FragmentB fragmentB = new FragmentB();
        fragmentTransaction.replace(R.id.flContainer, fragmentB, "FragmentB").addToBackStack("fragB").commit();
    }
}