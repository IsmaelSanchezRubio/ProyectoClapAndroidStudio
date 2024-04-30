package com.ismaelsanchez.estasilistas.Extra;

import android.content.Context;
import android.content.res.Resources;

import com.ismaelsanchez.estasilistas.R;

public class x {
    private Context mContext;

    public x(Context context) {
        mContext = context;
    }

    public String obtenerMiCadena() {
        return mContext.getString(R.string.ip);
    }
    public String obtenerMiCadena2() {
        return mContext.getString(R.string.password);
    }
    public String obtenerMiCadena3() {
        return mContext.getString(R.string.port);
    }
}
