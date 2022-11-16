package com.kur.utils;

import io.github.palexdev.materialfx.enums.NotificationState;
import io.github.palexdev.materialfx.notifications.base.INotification;
import io.github.palexdev.materialfx.utils.StringUtils;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Region;

import java.time.Instant;
import java.util.function.BiConsumer;
import java.util.function.Function;

public class MyNotification implements INotification {

    //默认是未读状态
    private final ObjectProperty<NotificationState> state = new SimpleObjectProperty<>(NotificationState.UNREAD);
    private Function<Long, String> timeToStringConverter = StringUtils::timeToHumanReadable;
    private BiConsumer<Long, String> onUpdate = (elapsedLong, elapsedString) -> {
    };
    private Region content;
    //创建时间
    private long createdTime;

    public MyNotification() {
        this(new AnchorPane());
    }

    public MyNotification(Region content) {
        createdTime = Instant.now().getEpochSecond();
        if (content == null) {
            throw new NullPointerException("内容为空!");
        }
        this.content = content;
    }


    /**
     * 获取内容
     *
     * @return {@link Region}
     */
    @Override
    public Region getContent() {
        return content;
    }

    /**
     * 设置内容
     *
     * @param content 内容
     */
    public void setContent(Region content) {
        this.content = content;
    }


    /**
     * 获得状态
     *
     * @return {@link NotificationState}
     */
    @Override
    public NotificationState getState() {
        return state.get();
    }


    @Override
    public ObjectProperty<NotificationState> notificationStateProperty() {
        return state;
    }


    /**
     * 设置通知状态
     *
     * @param state 状态
     */
    @Override
    public void setNotificationState(NotificationState state) {
        this.state.set(state);
    }


    /**
     * 有时间
     *
     * @return long
     */
    @Override
    public long getTime() {
        return createdTime;
    }

    /**
     * 设定了时间
     *
     * @param createdTime 创建时间
     */
    protected void setCreatedTime(long createdTime) {
        this.createdTime = createdTime;
    }


    /**
     * 运行时间
     *
     * @return long
     */
    @Override
    public long getElapsedTime() {
        return Instant.now().getEpochSecond() - createdTime;
    }


    /**
     * 让时间字符串转换器
     *
     * @return {@link Function}<{@link Long}, {@link String}>
     */
    @Override
    public Function<Long, String> getTimeToStringConverter() {
        return timeToStringConverter;
    }


    /**
     * 设置时间字符串转换器
     *
     * @param converter 转换器
     */
    @Override
    public void setTimeToStringConverter(Function<Long, String> converter) {
        this.timeToStringConverter = converter;
    }


    /**
     * 更新时间
     */
    @Override
    public void updateElapsed() {
        long elapsedTime = getElapsedTime();
        onUpdate.accept(elapsedTime, timeToStringConverter.apply(elapsedTime));
    }


    /**
     * 设置更新时间
     *
     * @param elapsedConsumer 经过消费者
     */
    @Override
    public void setOnUpdateElapsed(BiConsumer<Long, String> elapsedConsumer) {
        this.onUpdate = elapsedConsumer;
    }

    public static class Builder {
        private final MyNotification notification = new MyNotification();

        protected Builder() {
        }

        public static MyNotification.Builder build() {
            return new MyNotification.Builder();
        }

        public MyNotification.Builder setContent(Region content) {
            if (content == null) {
                throw new IllegalArgumentException("内容不能为空!");
            }
            notification.setContent(content);
            return this;
        }

        public MyNotification.Builder setState(NotificationState state) {
            notification.setNotificationState(state);
            return this;
        }

        public MyNotification.Builder setTimeToStringConverter(Function<Long, String> converter) {
            notification.setTimeToStringConverter(converter);
            return this;
        }

        public MyNotification.Builder setOnUpdateElapsed(BiConsumer<Long, String> elapsedConsumer) {
            notification.setOnUpdateElapsed(elapsedConsumer);
            return this;
        }

        public MyNotification get() {
            return notification;
        }
    }
}
