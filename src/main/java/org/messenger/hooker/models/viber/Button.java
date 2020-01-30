package org.messenger.hooker.models.viber;

import com.google.gson.annotations.SerializedName;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;

@NoArgsConstructor
@Getter
@Setter
public class Button {
    @SerializedName("Columns")
    private int columns;
    @SerializedName("Rows")
    private int rows;
    @SerializedName("BgColor")
    private String bgColor;
    @SerializedName("BgMediaType")
    private String bgMediaType;
    @SerializedName("BgMedia")
    private String bgMedia;
    @SerializedName("BgLoop")
    private Boolean bgLoop;
    @SerializedName("Text")
    private String text;
    @SerializedName("ActionType")
    private String actionType;

    public Button setActionBody(String actionBody) {
        this.actionBody = actionBody;
        return this;
    }

    @SerializedName("ActionBody")
    private String actionBody;

    public int getColumns() {
        return columns;
    }

    public Button setColumns(int columns) {
        this.columns = columns;
        return this;
    }

    public int getRows() {
        return rows;
    }

    public Button setRows(int rows) {
        this.rows = rows;
        return this;
    }

    public String getBgColor() {
        return bgColor;
    }

    public Button setBgColor(String bgColor) {
        this.bgColor = bgColor;
        return this;
    }

    public String getBgMediaType() {
        return bgMediaType;
    }

    public Button setBgMediaType(String bgMediaType) {
        this.bgMediaType = bgMediaType;
        return this;
    }

    public String getBgMedia() {
        return bgMedia;
    }

    public Button setBgMedia(String bgMedia) {
        this.bgMedia = bgMedia;
        return this;
    }

    public Boolean getBgLoop() {
        return bgLoop;
    }

    public Button setBgLoop(Boolean bgLoop) {
        this.bgLoop = bgLoop;
        return this;
    }

    public String getText() {
        return text;
    }

    public Button setText(String text) {
        this.text = new String(text.getBytes(StandardCharsets.UTF_8), Charset.forName("ISO8859-1"));
        return this;
    }

    public String getActionType() {
        return actionType;
    }

    @Override
    public String toString() {
        return "Button{" +
                "columns=" + columns +
                ", rows=" + rows +
                ", bgColor='" + bgColor + '\'' +
                ", BgMediaType='" + bgMediaType + '\'' +
                ", BgMedia='" + bgMedia + '\'' +
                ", BgLoop=" + bgLoop +
                ", Text='" + text + '\'' +
                ", ActionType='" + actionType + '\'' +
                '}';
    }

    public Button setActionType(String actionType) {
        actionType = actionType;
        return this;
    }
}
