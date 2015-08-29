import os
import time
import datetime
import Adafruit_BluefruitLE

from m2x.client import M2XClient
from Adafruit_BluefruitLE.services import UART

# m2x info
DEVICE_ID = ###
PRIMARY_API_KEY = ###

# instantiate a client
client = M2XClient(key=PRIMARY_API_KEY)

# use our device
device = client.device(DEVICE_ID)

# use the temperature stream
stream = device.stream('temperature')

# create our bluetooth LE reader
ble = Adafruit_BluefruitLE.get_provider()

def main():

    ble.clear_cached_data()

    # get bluetooth adapter and turn it on
    adapter = ble.get_default_adapter()
    adapter.power_on()

    # disconnect old UART devices
    UART.disconnect_devices()

    try:
        adapter.start_scan()
        device = UART.find_device()
        if device is None:
            raise RuntimeError('Failed to find UART device!')
    finally:
        adapter.stop_scan()

    device.connect()
    print('Connected to device...')

    try:
        UART.discover(device)
        uart = UART(device)
        while True:
            received = uart.read(timeout_sec=30)
            if received is not None:
                print('Received: {0}'.format(received))
                print(datetime.datetime.strftime(datetime.datetime.now(), '%H:%M:%S'))
                stream.add_value(received)
            else:
                print('Received no data!')
                break
    finally:
        device.disconnect()

ble.initialize()
ble.run_mainloop_with(main)