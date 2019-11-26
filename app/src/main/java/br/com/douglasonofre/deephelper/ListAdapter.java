package br.com.douglasonofre.deephelper;

import java.util.List;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import br.com.douglasonofre.deephelper.dados.Meta;

public class ListAdapter extends ArrayAdapter<Meta> {

    // List context
    private final Context context;
    // List values
    private final List<Meta> metaList;

    public ListAdapter(Context context, List<Meta> metaList) {
        super(context, R.layout.activity_main, metaList);
        this.context = context;
        this.metaList = metaList;
    }

    @Override
    public View getView(int posicao, View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        View rowView = inflater.inflate(R.layout.activity_main, parent, false);

        TextView metaTexto = (TextView) rowView.findViewById(R.id.txtMetaLista);
        metaTexto.setText(metaList.get(posicao).getTexto());

        return rowView;
    }

}
