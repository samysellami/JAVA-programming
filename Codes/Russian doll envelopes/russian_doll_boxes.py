import bisect
import itertools

class Boxes:


    def permute(self, box):
        return list(itertools.permutations(box)) 

    def maxBoxes(self, E) -> int:
        E.sort(key=lambda x: (x[0], -x[1], -x[2]))
        dp = []
        for _, _, height in E:
            left = bisect.bisect_left(dp, height)
            if left == len(dp): dp.append(height)
            else: dp[left] = height
        return len(dp)

def main():
    try:
        input = open("input.txt", "r")
        output = open("output.txt",'w')  
        line = input.read()
        line = line.split()

        boxes = []
        n = int(len(line) / 3)

        for i in range(n):
            boxes.append( [int(x) for j, x in enumerate(line) if j < 3] )
            line = line[3:]
        print(boxes)

        max_box = Boxes()
        dp = []
        for i, box in enumerate(boxes):
            box_permute = max_box.permute(box)
            
            for box_p in box_permute: 
                boxes_p = boxes.copy()
                boxes_p[i] = box_p 
                dp.append( max_box.maxBoxes(boxes_p) )

        solution = max(dp)
        print(solution)

        output.write(f'{solution}')

    finally:
        input.close()
        output.close()


if __name__ == "__main__":
    main()


