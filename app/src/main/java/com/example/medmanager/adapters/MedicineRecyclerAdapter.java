package com.example.medmanager.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.medmanager.databinding.MedicineItemBinding;
import com.example.medmanager.models.Medicine;
import com.example.medmanager.staticData.Data;

import java.util.List;


public class MedicineRecyclerAdapter extends RecyclerView.Adapter<MedicineRecyclerAdapter.ViewHolder> {
    private List<Medicine> data;


    public MedicineRecyclerAdapter(Context context) {
        this.data = Data.getMedicines();

    }

    public void setMedicineList(List<Medicine> data) {
        this.data = data;
    }

    public void refresh(List<Medicine> MedicineList) {
        notifyItemRangeRemoved(0, this.data.size());
        this.data.clear();
        this.data.addAll(MedicineList);
        notifyItemRangeInserted(0, this.data.size());
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        MedicineItemBinding itemBinding = MedicineItemBinding.inflate(layoutInflater, parent, false);
        return new ViewHolder(itemBinding);

    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Medicine med = data.get(position);
        holder.bind(med);
    }

    @Override
    public int getItemCount() {
        System.out.println("-------------------------" + data.size());
        return data.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        private TextView name;
        private TextView price;
        private TextView quantity;
        private ImageButton edit;
        private ImageButton delete;
        private Medicine medicine;

        MedicineItemBinding binding;

        public ViewHolder(@NonNull MedicineItemBinding binding) {
            super(binding.getRoot());
            this.binding = binding;

            name = binding.txtNameMedicineItem;
            price = binding.txtUnityMedicineItem;
            quantity = binding.txtQuantityMedicineItem;
            edit = binding.btnEditMedicineItem;
            delete = binding.btnDeleteMedicineItem;

        }

        public void bind(Medicine medicine) {
            this.medicine = medicine;
            name.setText(medicine.getName());
            quantity.setText(String.format("Quantity: %d", medicine.getQuantity()));
            price.setText(String.format("Unity Price: %s", medicine.getUnityPrice()));

        }

    }
}
