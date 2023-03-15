package com.sinhvien.myrex;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.BaseExpandableListAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.List;

public class note_adapter extends BaseAdapter {

    private Context context;
    private List<note_tu> note_tuList;

    public note_adapter(Context context, List<note_tu> note_tuList) {
        this.context = context;
        this.note_tuList = note_tuList;
    }

    @Override
    public int getCount() {
        return note_tuList.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    private class ViewHolder
    {
        TextView txtTu, txtDinhNghia;
        ImageView imgHinh;
    }

    @Override
    public View getView(int position, View View, ViewGroup parent) {
        ViewHolder holder;

        if (View == null)
        {
            holder = new ViewHolder();
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            View = inflater.inflate(R.layout.activity_note_listitem, null, true);
            holder.txtTu = (TextView) View.findViewById(R.id.txtWordCustom);
            holder.txtDinhNghia = (TextView) View.findViewById(R.id.txtWordDefCustom);
            holder.imgHinh = (ImageView) View.findViewById(R.id.imgCustom);
            View.setTag(holder);
        }
        else {
            holder = (ViewHolder) View.getTag();
        }
        note_tu noteTu = note_tuList.get(position);

        holder.txtTu.setText(noteTu.getTenTu());
        holder.txtDinhNghia.setText(noteTu.getDinhNghia());
        byte[] hinhAnh = noteTu.getHinhanh();
        Bitmap bitmap = BitmapFactory.decodeByteArray(hinhAnh, 0 ,hinhAnh.length);
        holder.imgHinh.setImageBitmap(bitmap);

        return View;
    }
}
