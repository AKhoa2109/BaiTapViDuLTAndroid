package com.android.btlistview;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.android.btlistview.adapter.MonHocAdapter;
import com.android.btlistview.model.MonHoc;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ListView listView;
    Button btnThem,btnCapNhat,btnXoa;
    EditText edText;

    int viTri = -1;
    ArrayList<String> arrayList = new ArrayList<>();
    ArrayList<MonHoc> arrayListMH = new ArrayList<>();
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

        AnhXa();
        arrayListMH = new ArrayList<>();
        arrayListMH.add(new MonHoc("Java","Java 1",R.drawable.java1));
        arrayListMH.add(new MonHoc("C#","C# 1",R.drawable.c));
        arrayListMH.add(new MonHoc("PHP","PHP 1",R.drawable.php));
        arrayListMH.add(new MonHoc("Kotlin","Kotlin 1",R.drawable.kotlin));
        arrayListMH.add(new MonHoc("Dart","Dart 1",R.drawable.dart));
        /*arrayList.add("Java");
        arrayList.add("C#");
        arrayList.add("PHP");
        arrayList.add("Kotlin");
        arrayList.add("Dart");*/

        MonHocAdapter adapter = new MonHocAdapter(MainActivity.this, R.layout.row_monhoc,arrayListMH);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener()
        {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l)
            {
                Toast.makeText(MainActivity.this, ""+i, Toast.LENGTH_SHORT).show();
                edText.setText(arrayListMH.get(i).getName());
                viTri = i;
            }
        });

        listView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long l) {

                Toast.makeText(MainActivity.this, "Bạn đang nhấn giữ "+i+" - "+arrayListMH.get(i).getName(), Toast.LENGTH_SHORT).show();
                return false;
            }
        });

        btnThem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name = edText.getText().toString();
                arrayList.add(name);
                adapter.notifyDataSetChanged();
            }
        });

        btnCapNhat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                arrayList.set(viTri,edText.getText().toString());
                adapter.notifyDataSetChanged();
            }
        });
        btnXoa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                arrayList.remove(viTri);
                adapter.notifyDataSetChanged();
            }
        });
    }

    private void AnhXa()
    {
        listView = (ListView) findViewById(R.id.listView);
        btnThem = (Button) findViewById(R.id.btnNhap);
        edText = (EditText) findViewById(R.id.editText);
        btnCapNhat = (Button) findViewById(R.id.btnCapNhat);
        btnXoa = (Button) findViewById(R.id.btnXoa);


    }

}