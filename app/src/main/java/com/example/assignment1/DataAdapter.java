package com.example.assignment1;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class DataAdapter extends RecyclerView.Adapter<DataAdapter.ViewHolder>{

    // ivar for DataAdapter
    private final Context context;
    private final int layoutID;
    private final Musician[] musicians;
    private final RecyclerViewInterface recyclerViewInterface;
    public DataAdapter(Context context, int layoutID, Musician[] musicians, RecyclerViewInterface recyclerViewInterface) {
        this.context = context;
        this.layoutID = layoutID;
        this.musicians = musicians;
        this.recyclerViewInterface = recyclerViewInterface;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        // inflate the layout and make it a viewHolder
        View v = LayoutInflater.from(this.context).inflate(layoutID, parent, false);

        return new ViewHolder(v, recyclerViewInterface);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        // populate viewHolder with model data
        // people[position].getText()
        holder.name.setText(musicians[position].getName());
        holder.role.setText("Role: " + musicians[position].getRole());
        String imageName = musicians[position].getImage();
        holder.image.setImageResource(context.getResources().getIdentifier(imageName, "drawable", context.getPackageName()));
    }

    @Override
    public int getItemCount() {
        return musicians.length;
    }


    // inner class for ViewHolder
    public static class ViewHolder extends RecyclerView.ViewHolder{
        // Need a listener and also need an onItemClick Function
        // in main activity to add the click functionality -> Interface.

        public TextView name, role;
        public ImageView image;

        public ViewHolder(@NonNull View itemView, RecyclerViewInterface recyclerViewInterface) {
            super(itemView);

            name  = itemView.findViewById(R.id.textView);
            role = itemView.findViewById(R.id.textView2);
            image = itemView.findViewById(R.id.imageView);

            itemView.setOnClickListener(new View.OnClickListener(){
                @Override
                public void onClick(View view) {
                    // Call the recycleViewInterface method
                    if (recyclerViewInterface != null){
                        //get position
                        int position = getAdapterPosition();
                        if (position != RecyclerView.NO_POSITION){
                            recyclerViewInterface.onItemClick(position);
                        }
                    }
                }
            })
        ;}
    }
}
