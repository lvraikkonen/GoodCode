import sys
from time import sleep

from tqdm import tqdm

def viewBar(i):
    output = sys.stdout
    for count in range(i+1):
        second = 0.1
        sleep(second)
        output.write('\rcomplete percentage: %.0f%%' % count)
    output.flush()

viewBar(100)

for i in tqdm(range(1, 500)):
    sleep(0.01)