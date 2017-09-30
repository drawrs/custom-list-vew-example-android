package com.khilman.customlistview;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    ListView listBuah;

    String namabuah[] = {"alpukat", "Apel", "Ceri", "Durian", "Jambu Air", "Manggis", "Strawberry"};
    int gambarbuah[] = {R.drawable.alpukat1,R.drawable.apel1,
            R.drawable.ceri1, R.drawable.duriani, R.drawable.jambuairi, R.drawable.manggisi, R.drawable.strawberrya};
    int suarabuah[] = {R.raw.alpukat, R.raw.apel, R.raw.ceri, R.raw.durian, R.raw.jambuair, R.raw.manggis, R.raw.strawberry};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listBuah = (ListView) findViewById(R.id.listBuah);
        // data yg dibawa : context, namabuah, gambarbuah
        ListViewAdapter adapter = new ListViewAdapter(this, namabuah, gambarbuah);
        // set adapter ke widget list view
        listBuah.setAdapter(adapter);
        // event onItemClick
        listBuah.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                Toast.makeText(MainActivity.this, "" + namabuah[position], Toast.LENGTH_SHORT).show();

                Intent intent = new Intent(MainActivity.this, DetailActivity.class);
                // buat intent membawa data
                intent.putExtra("nb", namabuah[position]);
                intent.putExtra("gb", gambarbuah[position]);
                intent.putExtra("sb", suarabuah[position]);

                // mulai activity baru
                startActivity(intent);
            }
        });
    }
}
