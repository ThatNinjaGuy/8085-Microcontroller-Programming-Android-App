package vishalgautam.a8085emulator;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class SampleCodes extends AppCompatActivity {

    private static RecyclerView sample_codes;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sample_codes);

        final String[] TitleArray = getResources().getStringArray(R.array.sample_codes_title);
        sample_codes = (RecyclerView)findViewById(R.id.sample_codes);
        sample_codes.setLayoutManager(new LinearLayoutManager(this));
        sample_codes.setNestedScrollingEnabled(false);
        sample_codes.setAdapter(new GeneralAdapter(this,TitleArray));

        sample_codes.addOnItemTouchListener(new RecyclerItemClickListener(this, sample_codes, new RecyclerItemClickListener.OnItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {
                Intent intent = new Intent(SampleCodes.this, Codes.class);
                intent.putExtra("POSITION",position);
                intent.putExtra("TITLE",TitleArray[position]);
                startActivity(intent);
            }

            @Override
            public void onItemLongClick(View view, int position) {

            }
        }));
    }
}

class GaneralViewHolder extends RecyclerView.ViewHolder{

    TextView textView;

    public GaneralViewHolder(View itemView) {
        super(itemView);
        textView = (TextView)itemView.findViewById(R.id.general_textView);
    }
}

class GeneralAdapter extends RecyclerView.Adapter<GaneralViewHolder>{

    Context context;
    LayoutInflater layoutInflater;
    String[] data;

    public GeneralAdapter(Context context,String[] data) {
        this.context = context;
        this.data = data;
        layoutInflater = LayoutInflater.from(context);
    }

    @Override
    public GaneralViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = layoutInflater.inflate(R.layout.general_layout,parent,false);
        return new GaneralViewHolder(view);
    }

    @Override
    public void onBindViewHolder(GaneralViewHolder holder, int position) {

        holder.textView.setText(data[position]);

    }

    @Override
    public int getItemCount() {
        return data.length;
    }


}