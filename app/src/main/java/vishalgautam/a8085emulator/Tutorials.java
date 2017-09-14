package vishalgautam.a8085emulator;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

public class Tutorials extends AppCompatActivity {

    static RecyclerView contents;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tutorials);

        final String contentsTitle[] = getResources().getStringArray(R.array.tutorials_title);
        final String contentsUrl[] = getResources().getStringArray(R.array.tutorials_url);

        contents = (RecyclerView)findViewById(R.id.contents);
        contents.setLayoutManager(new LinearLayoutManager(this));
        contents.setNestedScrollingEnabled(false);
        contents.setAdapter(new GeneralAdapter(this,contentsTitle));

        contents.addOnItemTouchListener(new RecyclerItemClickListener(this, contents, new RecyclerItemClickListener.OnItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {

                Intent intent = new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse(contentsUrl[position]));
                startActivity(intent);
            }

            @Override
            public void onItemLongClick(View view, int position) {

            }
        }));
    }
}
