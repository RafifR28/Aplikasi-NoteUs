package com.example.aplikasipencatatannoteus;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import com.firebase.ui.firestore.FirestoreRecyclerAdapter;
import com.firebase.ui.firestore.FirestoreRecyclerOptions;

public class CatatanAdapter extends FirestoreRecyclerAdapter<Catatan, CatatanAdapter.ViewHolder> {
    /**
     * Create a new RecyclerView adapter that listens to a Firestore Query.  See {@link
     * FirestoreRecyclerOptions} for configuration options.
     *
     * @param options
     */
    public CatatanAdapter(@NonNull FirestoreRecyclerOptions<Catatan> options) {
        super(options);
    }

    @Override
    protected void onBindViewHolder(@NonNull CatatanAdapter.ViewHolder holder, int position, @NonNull Catatan model) {
        holder.teksCatatan.setText(model.catatan);
        holder.teksNama.setText(model.email);
        Log.d("Data", "Catatan: " + model.catatan + ", Nama: " + model.email);
    }

    @NonNull
    @Override
    public CatatanAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);
        ViewHolder holder = new ViewHolder(inflater.inflate(R.layout.catatan_item, parent, false));
        return holder;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public TextView teksCatatan, teksNama;
        public ConstraintLayout itemLayout;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            teksCatatan = itemView.findViewById(R.id.txtCatatan);
            teksNama = itemView.findViewById(R.id.txtNama);
            itemLayout = itemView.findViewById(R.id.item_layout);
        }
    }
}
