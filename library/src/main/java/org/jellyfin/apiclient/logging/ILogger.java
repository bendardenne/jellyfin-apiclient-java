package org.jellyfin.apiclient.logging;

/**
 * Interface ILogger
 */
public interface ILogger {
    /**
     * Log at Debug level using a format string.
     *
     * @param formatString The format string.
     * @param paramList    The param list.
     */
    void debug(String formatString, Object... paramList);

    /**
     * Log at Info level using a format string.
     *
     * @param formatString The format string.
     * @param paramList    The param list.
     */
    void info(String formatString, Object... paramList);

    /**
     * Log at Error level using a format string.
     *
     * @param formatString The format string.
     * @param paramList    The param list.
     */
    void error(String formatString, Object... paramList);

    /**
     * Logs the exception with a format string message at Error level.
     *
     * @param formatString The message.
     * @param exception    The exception.
     * @param paramList    The param list.
     */
    void error(String formatString, Exception exception, Object... paramList);
}
