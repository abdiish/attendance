package adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.example.asistencia.R;

import java.util.List;

import entities.Group;

public class GroupAdapter extends RecyclerView.Adapter<GroupAdapter.GroupViewHolder> {

    private List<Group> groupList;
    private Context context;

    public GroupAdapter(List<Group> groupList, Context context) {
        this.groupList = groupList;
        this.context = context;
    }

    @NonNull
    @Override
    public GroupViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_list_groups,parent,false);
        return new GroupViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull GroupViewHolder holder, int position) {
        holder.txtGroupName.setText(groupList.get(position).getName_group());
    }

    @Override
    public int getItemCount() {
        return groupList.size();
    }

    public class GroupViewHolder extends RecyclerView.ViewHolder{

        private TextView txtGroupName;

        public GroupViewHolder(@NonNull View itemView) {
            super(itemView);

            txtGroupName = itemView.findViewById(R.id.txtGroupName);
        }
    }
}
