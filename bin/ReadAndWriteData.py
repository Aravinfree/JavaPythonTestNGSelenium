import csv

class ReadAndWriteData:
    def __init__(self, file_path):
        self.file_path = file_path
        self.data = []

    def read_data_from_csv(self):
        with open(self.file_path, mode='r') as file:
            csv_reader = csv.DictReader(file)
            for row in csv_reader:
                self.data.append(row)

    def display_data(self):
        if not self.data:
            print("No data to display.")
            return

        header = self.data[0].keys()
        print("{:<15} {:<15} {:<15}".format(*header))
        print("-" * 45)
        
        for row in self.data:
            print("{:<15} {:<15} {:<15}".format(row['Name'], row['SkillSet'], row['Experience']))

if __name__ == "__main__":
    file_path = "D:\pythonfile.csv" 
    data_handler = ReadAndWriteData(file_path)
    data_handler.read_data_from_csv()
    data_handler.display_data()
