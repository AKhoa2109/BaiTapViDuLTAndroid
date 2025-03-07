package com.android.recycleview;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.android.recycleview.adapter.SongAdapter;
import com.android.recycleview.model.SongModel;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    SongAdapter mSongAdapter;
    ArrayList<SongModel> arrayList;
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

        arrayList = new ArrayList<>();
        arrayList.add(new SongModel("60696", "Em Gái Mưa", "Mưa trôi cả bầu trời nắng...", "Hương Tràm"));
        arrayList.add(new SongModel("68701", "Nơi Này Có Anh", "Em có biết anh nhớ em nhiều lắm...", "Sơn Tùng M-TP"));
        arrayList.add(new SongModel("60650", "Có Chàng Trai Viết Lên Cây", "Có chàng trai viết lên cây...", "Phan Mạnh Quỳnh"));
        arrayList.add(new SongModel("60610", "Hồng Nhan", "Cuộc đời con gái chẳng giống con trai...", "Jack"));
        arrayList.add(new SongModel("68656", "Sóng Gió", "Hồng trần trên đôi cánh tay...", "Jack & K-ICM"));
        arrayList.add(new SongModel("68685", "Bông Hoa Đẹp Nhất", "Em là bông hoa đẹp nhất trong đời anh...", "Quân A.P"));
        arrayList.add(new SongModel("60752", "Chạy Ngay Đi", "Chạy ngay đi trước khi mọi điều dần tồi tệ hơn...", "Sơn Tùng M-TP"));
        arrayList.add(new SongModel("60608", "Anh Thương Em Nhất Mà", "Dù rằng em muốn xa anh, anh thương em nhất mà...", "Lã."));
        arrayList.add(new SongModel("68603", "Lạc Trôi", "Nước mắt ta rơi giữa trời...", "Sơn Tùng M-TP"));
        arrayList.add(new SongModel("68720", "Đau Nhất Là Lặng Im", "Anh chẳng thể nói ra lời yêu em...", "Erik"));
        arrayList.add(new SongModel("68856", "Quên Anh Là Điều Em Không Thể - Remix", "Cần thêm bao lâu để em quên đi niềm đau...", "Thiên Ngôn"));

        mSongAdapter = new SongAdapter(MainActivity.this, arrayList);
        recyclerView.setAdapter(mSongAdapter);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(linearLayoutManager);
    }

    private void AnhXa(){
        recyclerView = (RecyclerView) findViewById(R.id.rv_songs);
    }
}