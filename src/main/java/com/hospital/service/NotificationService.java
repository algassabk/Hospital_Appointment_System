package com.hospital.service;

import com.hospital.dto.NotificationDTO;
import com.hospital.model.Notification;
import com.hospital.model.User;
import com.hospital.repository.NotificationRepository;
import com.hospital.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NotificationService {

    private final NotificationRepository notificationRepository;
    private final UserRepository userRepository;

    public NotificationService(NotificationRepository notificationRepository, UserRepository userRepository) {
        this.notificationRepository = notificationRepository;
        this.userRepository = userRepository;
    }

    public Notification createNotification(NotificationDTO dto) {
        User user = userRepository.findById(dto.getUserId()).orElse(null);

        if (user == null) {
            return null;
        }

        Notification notification = new Notification();
        notification.setUser(user);
        notification.setTitle(dto.getTitle());
        notification.setMessage(dto.getMessage());
        notification.setIsRead(dto.getIsRead());

        return notificationRepository.save(notification);
    }

    public List<Notification> getAllNotifications() {
        return notificationRepository.findAll();
    }

    public Notification getNotificationById(Integer id) {
        return notificationRepository.findById(id).orElse(null);
    }

    public Notification updateNotification(Integer id, NotificationDTO dto) {
        Notification notification = notificationRepository.findById(id).orElse(null);
        User user = userRepository.findById(dto.getUserId()).orElse(null);

        if (notification == null || user == null) {
            return null;
        }

        notification.setUser(user);
        notification.setTitle(dto.getTitle());
        notification.setMessage(dto.getMessage());
        notification.setIsRead(dto.getIsRead());

        return notificationRepository.save(notification);
    }

    public void deleteNotification(Integer id) {
        notificationRepository.deleteById(id);
    }
}