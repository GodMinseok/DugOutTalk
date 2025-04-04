package hello.DugOutTalk.web;

import org.springframework.stereotype.Component;

import java.time.Duration;
import java.time.LocalDateTime;

@Component("timeUtil")
public class TimeUtil {

    public String toRelative(LocalDateTime time) {
        if (time == null) return "";

        Duration duration = Duration.between(time, LocalDateTime.now());

        if (duration.toMinutes() < 1) return "방금 전";
        if (duration.toMinutes() < 60) return duration.toMinutes() + "분 전";
        if (duration.toHours() < 24) return duration.toHours() + "시간 전";
        if (duration.toDays() < 7) return duration.toDays() + "일 전";

        return time.toLocalDate().toString(); // yyyy-MM-dd
    }
}
