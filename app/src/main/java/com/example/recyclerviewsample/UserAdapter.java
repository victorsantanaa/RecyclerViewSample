package com.example.recyclerviewsample;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class UserAdapter extends RecyclerView.Adapter<UserAdapter.UserAdapterVH> implements Filterable {

    private List<UserModel> userModelList;
    private List<UserModel> getUserModelListFiltered;
    private Context context;
    private SelectedUser selectedUser;

    public UserAdapter(List<UserModel> userModelList, SelectedUser selectedUser) {
        this.userModelList = userModelList;
        this.getUserModelListFiltered = userModelList;
        this.selectedUser = selectedUser;
    }

    @NonNull
    @Override
    public UserAdapterVH onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        context = parent.getContext();

        return new UserAdapterVH(LayoutInflater.from(context).inflate(R.layout.row_users, null));
    }

    @Override
    public void onBindViewHolder(@NonNull UserAdapterVH holder, int position) {
        UserModel userModel = userModelList.get(position);

        String username = userModel.getUserName();
        String prefix = userModel.getUserName().substring(0,1);
        String tpi = userModel.getTpi();

        holder.tvUserName.setText(username);
        holder.tvPrefix.setText(prefix);
        holder.tvTpi.setText(tpi);
    }

    @Override
    public int getItemCount() {
        return userModelList.size();
    }

    @Override
    public Filter getFilter() {

        Filter filter = new Filter() {
            @Override
            protected FilterResults performFiltering(CharSequence constraint) {
                FilterResults filterResults = new FilterResults();

                if(constraint == null | constraint.length()==0){
                    filterResults.count = getUserModelListFiltered.size();
                    filterResults.values = getUserModelListFiltered;
                }else {
                    String searchChr = constraint.toString().toLowerCase();

                    List<UserModel> resultData = new ArrayList<>();

                    for(UserModel userModel: getUserModelListFiltered){
                        if(userModel.getUserName().toLowerCase().contains(searchChr)){
                            resultData.add(userModel);
                        }
                    }

                    filterResults.count = resultData.size();
                    filterResults.values = resultData;
                }
                return filterResults;
            }

            @Override
            protected void publishResults(CharSequence constraint, FilterResults results) {
                userModelList = (List<UserModel>) results.values;
                notifyDataSetChanged();
            }
        };
        return filter;
    }

    public interface SelectedUser{
        void selectedUser(UserModel userModel);

    }

    public class UserAdapterVH extends RecyclerView.ViewHolder {

        TextView tvPrefix;
        TextView tvUserName;
        ImageView imIcon;
        TextView tvTpi;

        public UserAdapterVH(@NonNull View itemView) {
            super(itemView);
            tvPrefix = itemView.findViewById(R.id.prefix);
            tvUserName = itemView.findViewById(R.id.username);
            imIcon = itemView.findViewById(R.id.imageView);
            tvTpi = itemView.findViewById(R.id.tpi);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    selectedUser.selectedUser(userModelList.get(getAdapterPosition()));
                }
            });

        }
    }
}
