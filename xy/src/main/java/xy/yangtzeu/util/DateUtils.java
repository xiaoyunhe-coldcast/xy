package xy.yangtzeu.util;



import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Locale;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
 
/**
 * ���֡������ˡ����ڡ�������˵��<br/>
 * <p>
 * ʱ�乤����
 * <p>
 * @author 
 * 
 */
public class DateUtils {
     
    private static Logger log = LoggerFactory.getLogger(DateUtils.class);
     
    /**��ǰ����ֵ*/
    public static long NOW_DATE_MIS =getNowTime();
     
    /**���ݷ�����ȡ**/
    public static long getNowTime(){
        return new Date().getTime();   
    }
     
    /**
     * ��ȡ��ǰʱ���������ʱ����+ʱ�����4λ  ��:20140620123456   18λ
     * @return
     */
    public static String ymdhms4(){
        Date date = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
        String s = sdf.format(date);
        double a = Math.random() * 9000 + 1000;
        int result = (int)a;
        return s + result;
    }
    /**
     * ��һ���ַ���ʱ��ת��Ϊ����ֵ  �� 2014-12-12 12:12:12 ת��Ϊ 1406086513619
     * @param strDate
     * @return
     */
    public static long str2DateTime(String strDate){
        SimpleDateFormat df = new SimpleDateFormat("yyyyMMddHHmmss");
        Date date = new Date();
        try {
            date = df.parse(strDate);
        } catch (ParseException pe) {
            pe.getStackTrace();
        }
        return date.getTime() ;
    }
    /**
     * ��һ������ת��Ϊָ���ĸ�ʽ
     */  
    public static Date str2Date(String strDate, String formater) {
        if (strDate == null) {
            return null;
        }
        if (formater == null) {
            formater = "yyyy-MM-dd";
        }
        SimpleDateFormat df = new SimpleDateFormat(formater);
        Date date = new Date();
        try {
            date = df.parse(strDate);
        } catch (ParseException pe) {
            pe.getStackTrace();
        }
        return date;
    }
     
     
    /**
     * ��ȡ������ֵ
     * @param dateStr 2014-12-12 ��-��-�� ����
     * @return
     */
    public static Long getMaxMillsByYMD(String dateStr){
        if(StringUtils.isBlank(dateStr)){
            log.error("getTodayMaxMills error , message :param is empty");
            return null;
        }
        dateStr = dateStr.trim() + " 23:59:59";
        Date date = ymdHmsStr2Date(dateStr);
        return date.getTime() ;
    }
    private static Date ymdHmsStr2Date(String dateStr) {
		
		return null;
	}

	/**
     * ��ȡ��С����ֵ
     * @param dateStr 2014-12-12 �����ղ���
     * @return
     */
    public static Long getMinxMillsByYMD(String dateStr){
        if(StringUtils.isBlank(dateStr)){
            log.error("getTodayMaxMills error , message :param is empty");
            return null;
        }
        dateStr = dateStr.trim() + " 00:00:00";
        Date date = ymdHmsStr2Date(dateStr);
        return date.getTime() ;
    }
     
 
    public static String getNextMonth() {
        Calendar c = Calendar.getInstance();
        c.set(Calendar.DATE, 1);// ��Ϊ��ǰ�µ�1��
        c.add(Calendar.MONTH, 1);// ��һ���£���Ϊ���µ�1��
        return formaterDate(c.getTime(), "yyyy-MM");
    }
 
    private static String formaterDate(Date time, String string) {
		
		return null;
	}

	public static String getPreviousMonth() {
        Calendar c = Calendar.getInstance();
        c.set(Calendar.DATE, 1);// ��Ϊ��ǰ�µ�1��
        c.add(Calendar.MONTH, -1);// ��һ���£���Ϊ���µ�1��
        return formaterDate(c.getTime(), "yyyy-MM");
    }
 
    public static String getMonth(String date,int num) {
        Calendar c = Calendar.getInstance();
        if(StringUtils.isNotEmpty(date)){
            c.setTime(DateUtils.ymdStr2Date(date));
        }
        c.set(Calendar.DATE, 1);// ��Ϊ��ǰ�µ�1��
        c.add(Calendar.MONTH, num);// ��һ���£���Ϊ���µ�1��
        return formaterDate(c.getTime(), "yyyy-MM-dd");
    }
    private static Date ymdStr2Date(String date) {
		
		return null;
	}

	/**
    * ������������֮����������
    * @param date1
    * @param date2
    * @return
    */
    public static int getMonths(Date date1, Date date2) {
       int iMonth = 0;
        int flag = 0;
        try {
            Calendar objCalendarDate1 = Calendar.getInstance();
            objCalendarDate1.setTime(date1);
            Calendar objCalendarDate2 = Calendar.getInstance();
            objCalendarDate2.setTime(date2);
            if (objCalendarDate2.equals(objCalendarDate1))
                return 0;
            if (objCalendarDate1.after(objCalendarDate2)) {
                Calendar temp = objCalendarDate1;
                objCalendarDate1 = objCalendarDate2;
                objCalendarDate2 = temp;
            }
            if (objCalendarDate2.get(Calendar.DAY_OF_MONTH) < objCalendarDate1
                    .get(Calendar.DAY_OF_MONTH))
                flag = 1;
 
            if (objCalendarDate2.get(Calendar.YEAR) > objCalendarDate1
                    .get(Calendar.YEAR))
                iMonth = ((objCalendarDate2.get(Calendar.YEAR) - objCalendarDate1
                        .get(Calendar.YEAR))
                        * 12 + objCalendarDate2.get(Calendar.MONTH) - flag)
                        - objCalendarDate1.get(Calendar.MONTH);
            else
                iMonth = objCalendarDate2.get(Calendar.MONTH) - objCalendarDate1.get(Calendar.MONTH) - flag;
 
        } catch (Exception e) {
            e.printStackTrace();
        }
        return iMonth;
    }
 
    @SuppressWarnings("unchecked")
    public static List getMonthList(String startDate,String endDate){
        if(StringUtils.isEmpty(startDate) || StringUtils.isEmpty(endDate)) {
            return new ArrayList();
        }
        List<String> dateList = new ArrayList<String>();
        //�õ���������֮���ж�����
        int num = getMonths(ymdStr2Date(startDate),ymdStr2Date(endDate));
        Calendar c = Calendar.getInstance();
        c.setTime(DateUtils.ymdStr2Date(startDate));
        dateList.add(formaterDate(c.getTime(), "yyyy-MM"));
        for(int i=0; i<num; i++){
            c.set(Calendar.DATE, 1);
            c.add(Calendar.MONTH, 1);
            dateList.add(formaterDate(c.getTime(), "yyyy-MM"));
        }
        return dateList;
    }
    /**
     * ��ȡ��ǰ���ڣ��й�, �磺������,����һ,���ڶ���
     */
    public static String cnWeek() {
        Calendar c = GregorianCalendar.getInstance();
        c.setFirstDayOfWeek(Calendar.SUNDAY);
        String[] s = { "������", "����һ", "���ڶ�", "������", "������", "������", "������" };
        return s[c.get(Calendar.DAY_OF_WEEK) - 1];
    }
 
    /**
     * �õ���ǰ���� �ټ�����ָ�������� ���õ���������
     * @param days
     * @return
     */
    public static Date getNewDayNumDate(int days){
        String today = getToday();
        String newDay = getNewDayNumDate(today,days);
        return ymdStr2Date(newDay);
    }
 
    private static String getNewDayNumDate(String today, int days) {
		
		return null;
	}

	private static String getToday() {
		return null;
	}

	// ���㵱�����һ��,�����ַ���
    public static String getMonthLastDay() {
        Calendar c = Calendar.getInstance();
        c.set(Calendar.DATE, 1);// ��Ϊ��ǰ�µ�1��
        c.add(Calendar.MONTH, 1);// ��һ���£���Ϊ���µ�1��
        c.add(Calendar.DATE, -1);// ��ȥһ�죬��Ϊ�������һ��
        return ymd(c.getTime());
    }
 
    private static String ymd(Date time) {
		
		return null;
	}

	// ���㵱�µ�һ��,�����ַ���
    public static String getMonthFirstDay() {
        Calendar c = Calendar.getInstance();
        c.set(Calendar.DATE, 1);// ��Ϊ��ǰ�µ�1��
        return ymd(c.getTime());
    }
    
    /**
     * ���ǰʮ��ʱ��
     * 
     * @param date
     * @return
     */
    public static String getPrevTenDay(int day) {
        Calendar c = Calendar.getInstance();
        c.setTime(new Date());
        c.set(Calendar.DAY_OF_YEAR, c.get(Calendar.DAY_OF_YEAR) - day);
        return ymdHms(c.getTime());
    }
 
 
    private static String ymdHms(Date time) {
		
		return null;
	}

	/**
     * �õ�һ���������ܼ�
     */
    public static String getWeekCS(Date date) {
 
        Calendar c = GregorianCalendar.getInstance();
        c.setTime(date);
        c.setFirstDayOfWeek(Calendar.SUNDAY);
        String[] s = { "sunday", "monday", "tuesday", "wednesday",
                "thursday", "friday", "saturday" };
        return s[c.get(Calendar.DAY_OF_WEEK) - 1];
    }
 
    /**
     * �õ�һ���������ܼ�
     */
    public static String getWeekInNum(Date date) {
 
        Calendar c = GregorianCalendar.getInstance();
        c.setTime(date);
        int weekDayNum = c.get(Calendar.DAY_OF_WEEK)-1;
        if(weekDayNum == 0){
            weekDayNum = 7;
        }
        return String.valueOf(weekDayNum);
    }
 
    /**
     *  ȡ����ʱ���Сʱֵ
     * @param endDate
     * @return
     */
    public static String makeHour(Date endDate) {
        String hour = "";
        if (endDate != null) {
            DateFormat format = new SimpleDateFormat(
                    "yyyy-MM-dd HH:mm:ss");
            String after = format.format(endDate);
            hour = after.substring(11, 13);
        }
        return hour;
    }
 
    public static String makeMini(Date endDate) {
        String mini = "";
        if (endDate != null) {
            DateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            String after = format.format(endDate);
            mini = after.substring(14, 16);
        }
        return mini;
    }
     
    /**
     * �õ���ǰʱ��� Сʱ�ͷ֣�hh:mm��
     * @param date
     * @return
     */
    public static String getHourAndMinute(Date date){
        String hour = makeHour(date);
        String minute = makeMini(date);
         
        return hour + ":" + minute;
    }
 
    @SuppressWarnings("unchecked")
    public static List getTomorrowList() {
        List<String> dateList = new ArrayList<String>();
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Date());
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String tomorrow = sdf.format(calendar.getTime());
        dateList.add(tomorrow);
        for (int i = 0; i < 6; i++) {
            calendar.set(6, calendar.get(6) + 1);
            tomorrow = sdf.format(calendar.getTime());
            dateList.add(tomorrow);
        }
 
        return dateList;
    }
     
    public static String getWeekStartDateString(String startDate) {
        return getWeekDateString(startDate, 0);
    }
     
    public static String getWeekEndDateString(String endDate) {
        return getWeekDateString(endDate, 6);
    }
     
    public static String getWeekDateString(String currentDate, int day) {
        // ����
        Calendar calendar = new GregorianCalendar();
        // ��������Ϊ��ǰʱ��
        calendar.setTime(ymdStr2Date(currentDate));
        // �õ��������ܼ�
        int dayofweek = calendar.get(Calendar.DAY_OF_WEEK);
        int weekofYear = calendar.get(Calendar.WEEK_OF_YEAR);
        // ���벻�����գ��������ڵ���һ��
        if (dayofweek == 1) {
            calendar.set(Calendar.WEEK_OF_YEAR, weekofYear - 1);
        }
        int nextWeekDay = calendar.get(Calendar.DATE);
        // ��������Ϊ���ܵ�һ��,+2�����ܴ�����һ��ʼ������һ��ÿ�ܵĵ�2��
        calendar.set(Calendar.DATE, nextWeekDay - dayofweek + 2);
        calendar.add(Calendar.DATE, day);
        return ymd(calendar.getTime());
    }
     
    public static Date[] getWeekStartAndEndDate(Date currentDate, int start) {
        // ��Ҫ���ص�����
        Date[] days = new Date[2];
        if(null != currentDate){
            // ����
            Calendar calendar = new GregorianCalendar();
            // ��������Ϊ��ǰʱ��
            calendar.setTime(currentDate);
            // �õ��������ܼ�
            int dayofweek = calendar.get(Calendar.DAY_OF_WEEK);
            int weekofYear = calendar.get(Calendar.WEEK_OF_YEAR);
            // ���벻�����գ��������ڵ���һ��
            if (dayofweek == 1) {
                calendar.set(Calendar.WEEK_OF_YEAR, weekofYear - 1);
            }
            // �õ���ǰ��ȫ��ĵڼ���
            int nextWeekDay = calendar.get(Calendar.DATE);
            // ��������Ϊ���ܵ�һ��,+5�����ܴ������Ŀ�ʼ����������ÿ�ܵĵ�5��
            calendar.set(Calendar.DATE, nextWeekDay - dayofweek + 2);
            calendar.add(Calendar.DATE, start);
            days[0] = calendar.getTime();
            days[0] = ymdHmsStr2Date(ymd(days[0]) + " 00:00:00");
            calendar.add(Calendar.DATE, 6);
            days[1] = calendar.getTime();
            days[1] = ymdHmsStr2Date(ymd(days[1]) + " 23:59:59");
        }
        return days;
    }
     
    public static String[] getWeekStartAndEndDate(String currentDate, int start) {
        // ��Ҫ���ص�����
        String[] days = new String[2];
        if(StringUtils.isEmpty(currentDate)){
            return days;
        }
        // ����
        Calendar calendar = new GregorianCalendar();
        // ��������Ϊ��ǰʱ��
        calendar.setTime(ymdStr2Date(currentDate));
        // �õ��������ܼ�
        int dayofweek = calendar.get(Calendar.DAY_OF_WEEK);
        int weekofYear = calendar.get(Calendar.WEEK_OF_YEAR);
        // ���벻�����գ��������ڵ���һ��
        if (dayofweek == 1) {
            if(weekofYear == 1){
                weekofYear = 53;
            }
            calendar.set(Calendar.WEEK_OF_YEAR, weekofYear - 1);
        }
        // �õ���ǰ��ȫ��ĵڼ���
        int nextWeekDay = calendar.get(Calendar.DATE);
        calendar.set(Calendar.DATE, nextWeekDay - dayofweek + 2);
        calendar.add(Calendar.DATE, start);
        days[0] = ymd(calendar.getTime());
        calendar.add(Calendar.DATE, 6);
        days[1] = ymd(calendar.getTime());
        return days;
    }
     
    public static String[] getThisWeekStartEndDays() {
        return getWeekStartAndEndDate(ymd(new Date()), 0);
    }
     
    public static String[] getLastWeekStartEndDays() {
        return getWeekStartAndEndDate(ymd(new Date()), -7);
    }
     
    public static String[] getNextWeekStartEndDays() {
        return getWeekStartAndEndDate(ymd(new Date()), 7);
    }
 
    @SuppressWarnings("unchecked")
    public static List getWeekDateList(String date) throws ParseException {
        List<String> dateList = new ArrayList<String>();
        Calendar calendar = Calendar.getInstance();
        SimpleDateFormat ymd = new SimpleDateFormat("yyyy-MM-dd");
        Date dateVar = ymd.parse(date);
        calendar.setTime(dateVar);
        dateList.add(date);
        for (int i = 1; i <= 6; i++) {
            calendar.set(6, calendar.get(6) + 1);
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            String tomorrow = sdf.format(calendar.getTime());
            dateList.add(tomorrow);
        }
        return dateList;
    }
     
    public static String getNextDay(String currentDate) {
        Date d = ymdStr2Date(currentDate);
        Calendar c = Calendar.getInstance();
        c.setTime(d);
        c.set(Calendar.DAY_OF_YEAR, c.get(Calendar.DAY_OF_YEAR) + 1);
        return ymd(c.getTime());
    }
     
    /**
     * ��ÿ�ʼʱ��ͽ���ʱ��֮���ʱ���б�
     * @param startDate
     * @param endDate
     * @return List<String>
     * @throws ParseException
     */
    @SuppressWarnings("unchecked")
    public static List getDateList(String startDate, String endDate) throws ParseException {
        List<String> dateList = new ArrayList<String>();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd", Locale.ENGLISH); // �趨��ʽ
        Date start = dateFormat.parse(startDate);
        Date end = dateFormat.parse(endDate);
        long day = ((end.getTime() - start.getTime()) / 1000);// ����
        day = day / (60 * 60 * 24); // ����
        for (int i = 0; i <= day; i++) {
            String date = getAfterSomeDayYms(startDate, i);
            dateList.add(date);
        }
        return dateList;
    }    
     
    private static String getAfterSomeDayYms(String startDate, int i) {

		return null;
	}

	/**
     * �ж�����ʱ�����µĵڼ���
     * @param date ����ʱ��
     * @return �ڼ���
     */
    public static int weekOfMonth(String date) {
        Date d = ymdStr2Date(date);
        Calendar c = Calendar.getInstance();
        c.setTime(d);
        return c.get(Calendar.WEEK_OF_MONTH);
    }
     
    /**
     * ��ȡ��ǰ���ڼ�
     */
    public static int weekDay(String date) {
        Date d = ymdStr2Date(date);
        Calendar c = Calendar.getInstance();
        c.setTime(d);
        c.setFirstDayOfWeek(Calendar.SUNDAY);
        return c.get(Calendar.DAY_OF_WEEK)-1;
 
 }
    /**
     * ��������date ǰ��beforHourСʱ��� ����
     * @param date
     * @param beforHour
     * @return
     */
    public static Date getBeforHourDate(Date date, int beforHour){
         
        if(date != null){
            Calendar c = Calendar.getInstance();
            c.setTime(date);
            c.set(Calendar.HOUR, c.get(Calendar.HOUR)-beforHour);
             
            return c.getTime();
        }
        return null;
    }
     
    /**
     * ȡ�������ڵ�ǰһ��
     * @param date
     * @return
     */
    public static Date getLastDay(Date date){
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.set(Calendar.DAY_OF_YEAR,
                calendar.get(Calendar.DAY_OF_YEAR) - 1);
        return calendar.getTime();
    }
     
    /**
     * ������ʱ����������
     * @param d1
     * @param d2
     * @return
     */
    public static int getDayNumBetween2Date(Date d1, Date d2){  
         
        if(isEqualsInYMD(d1, d2)){
            return 0;
        }
         
        long l = d2.getTime()-d1.getTime();   
        int day = (int) (l/(24*60*60*1000));
        if(day < 0){
            day = (-day);
        }
         
        int m = (int) (l%(24*60*60*1000));
        Calendar c = Calendar.getInstance();
        if(d1.compareTo(d2)<=0){
            c.setTime(d1);
            c.add(Calendar.MILLISECOND, m);
            if(isEqualsInYMD(d1, c.getTime())){
                return day;
            }else{
                return day+1;
            }
        }else{
            c.setTime(d2);
            c.add(Calendar.MILLISECOND, m);
            if(isEqualsInYMD(d2, c.getTime())){
                return day;
            }else{
                return day+1;
            }
        }
         
    }
     
    /**
     * ����ʱ���Ƿ��� ͬ�� ͬ�� ͬ��
     * ����ǣ��򷵻�true�����򷵻�false
     * @param d1
     * @param d2
     * @return
     */
    public static boolean isEqualsInYMD(Date d1, Date d2){
         
        Calendar c = Calendar.getInstance();
         
        c.setTime(d1);
        int year1 = c.get(Calendar.YEAR);
        int dayOfYear1 = c.get(Calendar.DAY_OF_YEAR);
         
        c.setTime(d2);
        int year2 = c.get(Calendar.YEAR);
        int dayOfYear2 = c.get(Calendar.DAY_OF_YEAR);
         
        if(year1 != year2){
            return false;
        }
        if(dayOfYear1 != dayOfYear2){
            return false;
        }
         
        return true;
    }
     
    /**
     * ��õ�ǰ�µ�ǰ i ����
     * @param i (henrry)
     * return �µ�����
     */
    public static String[] getMonthArr(int i){
        String arr[] = new String[i];
        Calendar c = Calendar.getInstance();
        int temp = 0;
        int tempp = 0;
        int year = 0;
        int month = 0;
        int m = i-1;
        for(int j=0;j<m;j++){
            if(i>12){
                temp = (i-1)/12;
                tempp = (i-1)%12;
                year  = c.get(Calendar.YEAR)-temp;
                month = c.get(Calendar.MONTH)-tempp+1;
                if(month<10 && month >0){
                    arr[j] = year+"-0"+month;
                }else if(month<0){
                    month = 12+month;
                    if(month<10){
                        arr[j] = (year-1)+"-0"+month;
                    }else{
                        arr[j] = (year-1)+"-"+month;
                    }
                }else if(month == 0){
                    arr[j] = (year-1)+"-"+12;
                }else{
                    arr[j] = year+"-"+month;
                }
            }else{
                year  = c.get(Calendar.YEAR);
                month = c.get(Calendar.MONTH)-i+2;
                if(month<10 && month >0){
                    arr[j] = year+"-0"+month;
                }else if(month<0){
                    month = 12+month;
                    if(month<10){
                        arr[j] = (year-1)+"-0"+month;
                    }else{
                        arr[j] = (year-1)+"-"+month;
                    }
                }else if(month==0){
                    arr[j] = (year-1)+"-"+12;
                }else{
                    arr[j] = year+"-"+month;
                }
            }
            i--;
        }
        int monthNow = c.get(Calendar.MONTH);
        if(monthNow>8){
            arr[m] = c.get(Calendar.YEAR) + "-" + (c.get(Calendar.MONTH)+1);
        }else{
            arr[m] = c.get(Calendar.YEAR) + "-0" + (c.get(Calendar.MONTH)+1);
        }
        return arr;
    }
   
    /**
     * �õ�����ʱ��֮��Ĳ�࣬����type�ɷ��طֱ����죬ʱ����Ϊ��λ������
     * @param d1
     * @param d2
     * @param type
     * @return
     */
    public static int getBetweenDateGap(Date d1, Date d2, String type){
        long time1 = d1.getTime();
        long time2 = d2.getTime();
        long m = (time1-time2)/1000;
        int nDay = (int)m/(24*60*60);      
        int nHour = (int)(m-nDay*24*60*60)/(60*60);
        int nMinute = (int)(m-nDay*24*60*60-nHour*60*60)/60;
        int mSecond = (int)(m-nDay*24*60*60-nHour*60*60);
        if("day".equals(type)){
            return nDay;
        }else if("minute".equals(type)){
            return nMinute;
        }else if("hour".equals(type)){
            return nHour;
        }else if("second".equals(type)){
            return mSecond;
        }
        return nMinute;
    }
 
    /**
     * *
     * ͨ���·ݼ��㼾�� *
     * @param
     * month *
     * @return
     */
    public static int getQuarter(int month) {
        if (month < 1 || month > 12) {
            throw new IllegalArgumentException("month is invalid.");
        }
        return (month - 1) / 3 + 1;
    }
}