package vishalgautam.a8085emulator;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class Instructions extends AppCompatActivity {

    private static RecyclerView EmulatorInstructions,OtherInstructions;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_instructions);

        EmulatorInstructions = (RecyclerView)findViewById(R.id.EmulatorInstructions);
        EmulatorInstructions.setAdapter(new InstructionsAdapter(this,getResources().getStringArray(R.array.emulator_instructions)));
        EmulatorInstructions.setLayoutManager(new LinearLayoutManager(this));
        EmulatorInstructions.setNestedScrollingEnabled(false);
        OtherInstructions = (RecyclerView)findViewById(R.id.OtherInstructions);
        OtherInstructions.setAdapter(new InstructionsAdapter(this,getResources().getStringArray(R.array.other_instructions)));
        OtherInstructions.setLayoutManager(new LinearLayoutManager(this));
        OtherInstructions.setNestedScrollingEnabled(false);
    }
}

class InstructionsAdapter extends RecyclerView.Adapter<InstructionsViewHolder>{

    Context context;
    String[] instructionsDatas;
    LayoutInflater layoutInflater;

    InstructionsAdapter(Context context, String[] instructionsDatas){
        this.context = context;
        this.instructionsDatas = instructionsDatas;
        layoutInflater = LayoutInflater.from(context);
    }

    @Override
    public void onBindViewHolder(InstructionsViewHolder holder, int position) {
        holder.textView.setText(instructionsDatas[position]);
    }

    @Override
    public InstructionsViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = layoutInflater.inflate(R.layout.instructions_layout,parent,false);
        return new InstructionsViewHolder(view);
    }

    @Override
    public int getItemCount() {
        return instructionsDatas.length;
    }
}

class InstructionsViewHolder extends RecyclerView.ViewHolder{

    TextView textView;

    public InstructionsViewHolder(View itemView) {
        super(itemView);
        textView = (TextView)itemView.findViewById(R.id.instructionData);
    }
}