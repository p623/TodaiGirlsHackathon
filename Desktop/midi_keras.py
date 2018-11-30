import tensorflow as tf
from tensorflow import keras
import numpy as np
import pretty_midi

print(tf.__version__)


train_data_content1 = pretty_midi.PrettyMIDI('clairdelune.mid')
train_data_content2 = pretty_midi.PrettyMIDI('ARAB2A.mid')
train_data_content3 = pretty_midi.PrettyMIDI('ARABQMB1.MID')
train_data_content4 = pretty_midi.PrettyMIDI('BERMENU.mid')
train_data_content5 = pretty_midi.PrettyMIDI('BERGAPRE.mid')
train_data_content6 = pretty_midi.PrettyMIDI('ETROILEM.MID')
train_data_content7 = pretty_midi.PrettyMIDI('REVPF.MID')
train_data_content8 = pretty_midi.PrettyMIDI('passepied.mid')
train_data_content = [train_data_content1, train_data_content2, train_data_content3, train_data_content4,
              train_data_content5, train_data_content6, train_data_content7, train_data_content8]
train_data=[]
train_labels=[]

for content in train_data_content:
   pianoP = content.get_piano_roll()
   # change 2D to 1D
   oneDPiano = tf.reshape(pianoP, [-1])
   sess = tf.Session()
   train_data.append(list(map(int, sess.run(oneDPiano))))
   train_labels.append(list(map(int, sess.run(oneDPiano))))

print("Training entries: {}, labels: {}".format(
    len(train_data), len(train_labels)))

print(max(train_data[0]))
print(max(train_data[1]))
print(max(train_data[2]))
print(max(train_data[3]))
print(max(train_data[4]))
print(max(train_data[5]))
print(max(train_data[6]))
print(max(train_data[7]))
print(len(train_data[0]))
print(len(train_data[1]))
print(len(train_data[2]))
print(len(train_data[3]))
print(len(train_data[4]))
print(len(train_data[5]))
print(len(train_data[6]))
print(len(train_data[7]))

train_data = keras.preprocessing.sequence.pad_sequences(train_data, maxlen=5000000)

# check that length of all data is equal to 5000000
print(len(train_data[0]))
print(len(train_data[1]))
print(len(train_data[2]))
print(len(train_data[3]))
print(len(train_data[4]))
print(len(train_data[5]))
print(len(train_data[6]))
print(len(train_data[7]))


vocab_size = 442

model = keras.Sequential()
model.add(keras.layers.Embedding(vocab_size, 16))
model.add(keras.layers.GlobalAveragePooling1D())
model.add(keras.layers.Dense(16, activation=tf.nn.relu))
model.add(keras.layers.Dense(vocab_size, activation=tf.nn.relu))

model.summary()

model.compile(optimizer=tf.train.AdamOptimizer(),
              loss='binary_crossentropy',
              metrics=['accuracy'])

x_val = train_data[:442]
partial_x_train = train_data[442:]

y_val = train_labels[:442]
partial_y_train = train_labels[442:]

history = model.fit(partial_x_train,
                    partial_y_train,
                    epochs=5,
                    batch_size=1,
                    validation_data=(x_val, y_val),
                    verbose=1)
