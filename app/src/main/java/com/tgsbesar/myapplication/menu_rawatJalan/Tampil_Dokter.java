package com.tgsbesar.myapplication.menu_rawatJalan;

import android.os.Bundle;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.tgsbesar.myapplication.R;

import java.util.ArrayList;

public class Tampil_Dokter extends AppCompatActivity {

    private RecyclerView recyclerView;
    private DokterAdapter adapter;
    private ArrayList<Dokter> dokterArrayList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tampil__dokter);

        addData();
        recyclerView = (RecyclerView) findViewById(R.id.recycler_view);
        adapter = new DokterAdapter(this,dokterArrayList);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);

    }

    public void addData(){
           String nama = getIntent().getStringExtra("nama");
           ArrayList<Dokter> data = (new DaftarDokter()).DOKTER;
           Log.d("MASUK",String.valueOf(data.size())+nama);
           dokterArrayList = new ArrayList<>();

           for(Dokter data2 : data){

               if(data2.getJabatan().contains(nama)){
                   dokterArrayList.add(data2);
                   Log.d("MASUK",data2.getJabatan() + nama );
               }
           }
    }
}