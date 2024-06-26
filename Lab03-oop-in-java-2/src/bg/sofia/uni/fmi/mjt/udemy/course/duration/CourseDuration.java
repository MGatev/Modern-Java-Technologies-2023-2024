package bg.sofia.uni.fmi.mjt.udemy.course.duration;

import bg.sofia.uni.fmi.mjt.udemy.course.Resource;

public record CourseDuration(int hours, int minutes) {
    public CourseDuration{
        if(hours < 0 || hours > 24 || minutes < 0 || minutes > 60)
            throw new IllegalArgumentException("Invalid time!");
    }
    public static CourseDuration of(Resource[] content){
        int totalMinutes = 0;
        for(Resource r : content){
            totalMinutes += r.getDuration().minutes();
        }

        int totalHours = 0;
        totalHours = totalMinutes / 60;
        totalMinutes -= (totalHours * 60);

        return new CourseDuration(totalHours, totalMinutes);
    }
}
