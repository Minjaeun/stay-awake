# from PIL import Image
import tensorflow as tf
import os
import numpy as np
import cv2
import matplotlib.pyplot as plt
from tensorflow.keras.preprocessing.image import ImageDataGenerator

# import matplotlib as plt
# train_size : 대략 25000
# test_size : 대략 1000

# opened = 0
# closed = 1

os.environ['TF_CPP_MIN_LOG_LEVEL'] = '3'


cropped_eyes_path = r'C:\Users\mlpa\Desktop\capston_drowsiness_detection_MLPA\dataset_rt-bene\dataset'

train_path = os.path.join(cropped_eyes_path, 'train')
test_path = os.path.join(cropped_eyes_path, 'test')

train_datagen = ImageDataGenerator(horizontal_flip = True, rescale=1./255)
test_datagen = ImageDataGenerator(rescale=1./255)

min_size = (85, 23)  # minimum size of opened
BATCH_SIZE = 16
EPOCHS = 40
train_batch = train_datagen.flow_from_directory(directory=train_path,
                                               target_size= min_size,
                                               class_mode='categorical',
                                               batch_size=BATCH_SIZE,
                                               shuffle=True)

test_batch = test_datagen.flow_from_directory(directory=test_path,
                                               target_size=min_size,
                                               class_mode='categorical',
                                               batch_size=BATCH_SIZE,
                                               shuffle=False)

print('model_making...')
model = tf.keras.Sequential([
    tf.keras.layers.Conv2D(16, (3, 3), activation='relu', input_shape=(85, 23, 3)),
    tf.keras.layers.MaxPooling2D(2, 2),
    tf.keras.layers.Conv2D(32, (3, 3), activation='relu'),
    tf.keras.layers.MaxPooling2D(2, 2),
    tf.keras.layers.Conv2D(64, (3, 3), activation='relu'),
    tf.keras.layers.MaxPooling2D(2, 2),
    tf.keras.layers.Flatten(),
    tf.keras.layers.Dense(512, activation='relu'),
    tf.keras.layers.Dense(2, activation='sigmoid')

])



print('....')

model.compile(optimizer='adam',
              loss = 'binary_crossentropy',
              metrics=['accuracy'])
# print('model compile')
model.summary()

#method 1. weight balancing
#class closed : open = 4856 : 108753
CLASS_WEIGHT =  {0 : 0.96,
                1 : 0.04 }
EPOCHS = 50


hist2 = model.fit(train_batch,
                  epochs=EPOCHS,
                  validation_data = test_batch,
                  verbose = 2,
                  class_weight = CLASS_WEIGHT
                 )


#plot the model result
acc = hist2.history['accuracy']
val_acc = hist2.history['val_accuracy']

loss = hist2.history['loss']
val_loss = hist2.history['val_loss']

epochs_range = range(EPOCHS)

print(hist2)

plt.figure(figsize=(8, 8))
plt.subplot(1, 2, 1)
plt.plot(epochs_range, acc, label='Training Accuracy')
plt.plot(epochs_range, val_acc, label="Validation Accuracy")
plt.legend(loc='lower right')
plt.title("Training and Validation Accuracy")

plt.subplot(1, 2, 2)
plt.plot(epochs_range, loss, label='Training Loss')
plt.plot(epochs_range, val_loss, label="Validation Loss")
plt.legend(loc='upper right')
plt.title("Training and Validation Loss")

plt.show()
# plot the model result


# test_loss, test_acc = model.evaluate(test_imgs,  test_labels, verbose=2)
test_loss, test_acc = model.evaluate(test_batch, verbose=2)

print('\nTest accuracy:', test_acc)

model.save('weight_balancing_model_final.h5')