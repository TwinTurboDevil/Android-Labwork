package com.example.processingunits;

import android.os.Bundle;
import android.view.View;
import android.widget.Spinner;
import android.app.Activity;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {


    public class UnitExpert {
        List<String> getComponent(String units)
        {
            List<String> Components = new ArrayList<>();
            if(units.equals("Central Processing Unit"))
            {
                Components.add("Bus");
                Components.add("Cache");
                Components.add("ALU");
            }
            else if(units.equals("Graphic Processing Unit"))
            {
                Components.add("Graphics Chip");
                Components.add("CUDA Cores");
                Components.add("Video Memory");
            }
            else {
                Components.add("Qubits");
                Components.add("Quantum Gates");
                Components.add("Control Electronics");
            }
            return Components;
        }
    }

    private UnitExpert expert = new UnitExpert();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

    public void onClickFindProcessingUnit(View view) {
        Spinner ProcessingUnitSpinner = (Spinner) findViewById(R.id.ProcessingUnitSpinner);
        String SelectedUnit = String.valueOf(ProcessingUnitSpinner.getSelectedItem());

        List<String> ComponentList = expert.getComponent(SelectedUnit);

        StringBuilder unitFormatted = new StringBuilder();
        for (String unit: ComponentList)
        {
            unitFormatted.append(unit).append('\n');
        }

        TextView ComponentTextView = (TextView) findViewById(R.id.ComponentTextView);
        ComponentTextView.setText(unitFormatted);
    }
}