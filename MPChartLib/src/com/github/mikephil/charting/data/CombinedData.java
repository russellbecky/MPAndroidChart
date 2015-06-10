
package com.github.mikephil.charting.data;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

/**
 * Data object that allows the combination of Line-, Bar-, Scatter-, Bubble- and
 * CandleData. Used in the CombinedChart class.
 * 
 * @author Philipp Jahoda
 */
public class CombinedData extends BarLineScatterCandleData<BarLineScatterCandleDataSet<?>> {

    private static final String DEFAULT_LINE_TAG = "DEFAULT_LINE_TAG";

    // BECKY - support multiple lines
    private HashMap<String, LineData> mLineDataHashMap;

    private BarData mBarData;
    private ScatterData mScatterData;
    private CandleData mCandleData;
    private BubbleData mBubbleData;

    public CombinedData() {
        super();

        if (mLineDataHashMap == null)
            mLineDataHashMap = new HashMap<String, LineData>();
    }

    public CombinedData(List<String> xVals) {
        super(xVals);

        if (mLineDataHashMap == null)
            mLineDataHashMap = new HashMap<String, LineData>();
    }

    public CombinedData(String[] xVals) {
        super(xVals);

        if (mLineDataHashMap == null)
            mLineDataHashMap = new HashMap<String, LineData>();
    }

    // BECKY - support multiple lines
    public void setData(LineData data) {
        mLineDataHashMap.put(DEFAULT_LINE_TAG, data);
        mDataSets.addAll(data.getDataSets());
        init(data.getDataSets());
    }

    // BECKY - support multiple lines
    public void setData(LineData data, String lineDataTagString) {
        mLineDataHashMap.put(lineDataTagString, data);
        mDataSets.addAll(data.getDataSets());
        init(data.getDataSets());
    }

    public void setData(BarData data) {
        mBarData = data;
        mDataSets.addAll(data.getDataSets());
        init(data.getDataSets());
    }

    public void setData(ScatterData data) {
        mScatterData = data;
        mDataSets.addAll(data.getDataSets());
        init(data.getDataSets());
    }

    public void setData(CandleData data) {
        mCandleData = data;
        mDataSets.addAll(data.getDataSets());
        init(data.getDataSets());
    }

    public void setData(BubbleData data) {
        mBubbleData = data;
        mDataSets.addAll(data.getDataSets());
        init(data.getDataSets());
    }

    public BubbleData getBubbleData() {
        return mBubbleData;
    }

    // BECKY - support multiple lines
    public LineData getLineData() {
        return mLineDataHashMap.get(DEFAULT_LINE_TAG);
    }

    // BECKY - support multiple lines
    public LineData getLineData(String lineDataTagString) {
        return mLineDataHashMap.get(lineDataTagString);
    }

    // BECKY - support multiple lines
    public HashMap<String, LineData> getAllLineData() {
        return mLineDataHashMap;
    }

    public BarData getBarData() {
        return mBarData;
    }

    public ScatterData getScatterData() {
        return mScatterData;
    }

    public CandleData getCandleData() {
        return mCandleData;
    }

    @Override
    public void notifyDataChanged() {

        // BECKY - support multiple lines
        if (mLineDataHashMap != null && mLineDataHashMap.size() > 0) {

            // Loop through each LineData object
            Iterator lineDataIterator = mLineDataHashMap.keySet().iterator();
            while(lineDataIterator.hasNext()) {
                String key = (String)lineDataIterator.next();
                ((LineData)mLineDataHashMap.get(key)).notifyDataChanged();
            }
        }
        if (mBarData != null)
            mBarData.notifyDataChanged();
        if (mCandleData != null)
            mCandleData.notifyDataChanged();
        if (mScatterData != null)
            mScatterData.notifyDataChanged();
        if (mBubbleData != null)
            mBubbleData.notifyDataChanged();
    }

    // BECKY
    public void setXValues(List<String> xVals) {
        this.mXVals = xVals;
        init(mDataSets);
    }
}
