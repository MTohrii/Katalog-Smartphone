package com.example.smartphonetopik7;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.smartphonetopik7.model.Lis;

import java.util.List;

public class DaftarSmrphoneAdapter extends ArrayAdapter<Lis> {
    Context context;

    public DaftarSmrphoneAdapter(@NonNull Context context, @NonNull List<Lis> objects) {
        super(context, R.layout.row_smart, objects);
        this.context = context;
    }

    class ViewHolder {
        TextView txSpesifikasi;
        TextView txHarga;
        TextView txBrand;
        TextView txModel;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        Lis tr = getItem(position);
        ViewHolder viewHolder;
        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(R.layout.row_smart, parent, false);
            viewHolder = new ViewHolder();
            viewHolder.txSpesifikasi = convertView.findViewById(R.id.row_spec);
            viewHolder.txHarga = convertView.findViewById(R.id.row_hrg);
            viewHolder.txBrand = convertView.findViewById(R.id.row_brn);
            viewHolder.txModel = convertView.findViewById(R.id.row_md);
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }
        viewHolder.txSpesifikasi.setText(tr.getSpesifikasi());
        viewHolder.txHarga.setText(tr.getHarga());
        viewHolder.txModel.setText(tr.getModel());
        if (tr.getBrand().equals(Lis.APPLE)) {
            viewHolder.txBrand.setText("APPLE");
        } else if (tr.getBrand().equals(Lis.SAMSUNG)) {
            viewHolder.txBrand.setText("SAMSUNG");
        } else if (tr.getBrand().equals(Lis.VIVO)) {
            viewHolder.txBrand.setText("VIVO");
        } else if (tr.getBrand().equals(Lis.OPPO)) {
            viewHolder.txBrand.setText("OPPO");
        } else if (tr.getBrand().equals(Lis.XIOMI)) {
            viewHolder.txBrand.setText("XIOMI");
        } else {
            viewHolder.txBrand.setText("UMUM");
        }
        return convertView;
    }
}

