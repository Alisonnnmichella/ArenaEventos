package UI;

import org.apache.commons.lang.StringUtils;
import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.uqbar.arena.bindings.ValueTransformer;
import org.uqbar.commons.model.exceptions.UserException;

public class LocalDateTransformer implements ValueTransformer<DateTime,String> {
    private String pattern="dd/MM/yyyy";

    @Override
    public DateTime viewToModel(String valueFromView) {
        try {
            String pattern = "yyyy-MM-dd";
            if (StringUtils.isBlank(valueFromView))
                return null;
            else {
                DateTime date = DateTime.parse(valueFromView, DateTimeFormat.forPattern(pattern));
                return date;

            }
        }catch (Exception e) {
            throw new UserException("Debe ingresar una fecha en el siguiente formato: " +pattern);
        }

    }

    @Override
    public String modelToView(DateTime valueFromModel) {
        if (valueFromModel == null)
            return null;
        else
            return valueFromModel.toString(pattern);

    }

    @Override
    public Class<DateTime> getModelType() {
         return   DateTime.class;
        }

    @Override
    public Class<String> getViewType() {
        return String.class;
    }
}
