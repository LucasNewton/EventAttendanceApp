package com.dev.mobile.eventattendance;
import com.github.barteksc.pdfviewer.PDFView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class MaterialMenu extends AppCompatActivity {

    public AppDatabase db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_material_menu);

        db = AppDatabase.getAppDatabase(getApplicationContext());

        final String[] sourceFiles = db.dbInterface().getMaterials();

        /*final String [] sourceFiles = {
                "MobileAppProposal.pdf",
                "MobileAppProposal2.pdf"
        };*/

        final Button pdfButton1 = (Button) findViewById(R.id.PDF1Button);
        pdfButton1.setOnClickListener(new View.OnClickListener() {
            public void onClick (View v){
                Intent i = new Intent(MaterialMenu.this, PDFViewer.class);
                i.putExtra("src", sourceFiles [0]);
                startActivity(i);
            }
        });

        final Button pdfButton2 = (Button) findViewById(R.id.PDF2Button);
        pdfButton2.setOnClickListener(new View.OnClickListener() {
            public void onClick (View v){
                Intent i = new Intent(MaterialMenu.this, PDFViewer.class);
                i.putExtra("src", sourceFiles [1]);
                startActivity(i);
            }
        });
    }

    private void searchForFiles ()
    {
        //  Maybe implement later if we want this feature
    }
}