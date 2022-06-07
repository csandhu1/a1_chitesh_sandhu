package com.example.a1_chitesh_sandhu;

import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.example.a1_chitesh_sandhu.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {
    private ActivityMainBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.tvChangesBreakDown.setVisibility(View.GONE);
        binding.tvTaxes.setVisibility(View.GONE);
        binding.tvTotalUsage.setVisibility(View.GONE);
        binding.tvTotalBill.setVisibility(View.GONE);
        // click action for Calculate button
        binding.btnCalculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d("ABC", "Button was pressed");


                // validate that the form fields are filled in
                String morningUsageFromUI = binding.etMorningUsage.getText().toString();
                String afternoonUsageFromUI = binding.etAfternoonUsage.getText().toString();
                String eveningUsageFromUI = binding.etEveningUsage.getText().toString();

                if (morningUsageFromUI.isEmpty() || afternoonUsageFromUI.isEmpty() || eveningUsageFromUI.isEmpty()){
                    Log.d("ABC", "Values must be filled in");
                    binding.tvDetails.setText("Values must be entered");
                    binding.tvDetails.setTextColor(Color.parseColor("#FF00FF"));
                    return;
                }
                else{
                    Double morningUsage = Double.parseDouble(morningUsageFromUI);
                    Double afternoonUsage = Double.parseDouble(afternoonUsageFromUI);
                    Double eveningUsage = Double.parseDouble(eveningUsageFromUI);

                    Bill bill = new Bill(morningUsage, afternoonUsage, eveningUsage, binding.swUsesRenewableEnergy.isChecked());
                    binding.tvDetails.setVisibility(View.GONE);
                    binding.tvDetails.setText(bill.getDetails());
                    binding.tvDetails.setVisibility(View.VISIBLE);
                    binding.tvTotalUsage.setText(bill.getTotalUsage());
                    binding.tvTaxes.setText(bill.getTaxes());
                    binding.tvTotalBill.setText(bill.getTotalBill());

                    binding.tvChangesBreakDown.setVisibility(View.VISIBLE);
                    binding.tvTaxes.setVisibility(View.VISIBLE);
                    binding.tvTotalUsage.setVisibility(View.VISIBLE);
                    binding.tvTotalBill.setVisibility(View.VISIBLE);

                }

            }
        });

        binding.btnReset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                binding.etMorningUsage.setText("");
                binding.etAfternoonUsage.setText("");
                binding.etEveningUsage.setText("");
                binding.swUsesRenewableEnergy.setChecked(false);
                binding.tvDetails.setText("Your Electricity Bill will be calculated here");
                binding.tvChangesBreakDown.setVisibility(View.GONE);
                binding.tvTaxes.setVisibility(View.GONE);
                binding.tvTotalUsage.setVisibility(View.GONE);
                binding.tvTotalBill.setVisibility(View.GONE);
            }
        });

    }
}