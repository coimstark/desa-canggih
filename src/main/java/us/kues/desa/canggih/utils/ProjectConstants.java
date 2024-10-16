package us.kues.desa.canggih.utils;

import java.util.Locale;


/**
 * Created on 16 Oktober, 2024
 *
 * @author Coim
 */
public final class ProjectConstants {

	// FIXME : Customize project constants for your application.

	public static final String DEFAULT_ENCODING = "UTF-8";

	public static final Locale INDONESIAN_LOCALE = new Locale.Builder().setLanguage("id").setRegion("ID").build();

	public static final Locale TURKISH_LOCALE = new Locale.Builder().setLanguage("tr").setRegion("TR").build();

	private ProjectConstants() {

		throw new UnsupportedOperationException();
	}

}
