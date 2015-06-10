
package com.github.mikephil.charting.interfaces;

import com.github.mikephil.charting.data.LineData;
import com.github.mikephil.charting.utils.FillFormatter;

import java.util.HashMap;

public interface LineDataProvider extends BarLineScatterCandleDataProvider {

    public LineData getLineData();
    public HashMap<String, LineData> getAllLineData();

    /**
     * Sets a custom FillFormatter to the chart that handles the position of the
     * filled-line for each DataSet. Set this to null to use the default logic.
     * 
     * @param formatter
     */
    public void setFillFormatter(FillFormatter formatter);

    /**
     * Returns the FillFormatter that handles the position of the filled-line.
     * 
     * @return
     */
    public FillFormatter getFillFormatter();
}
