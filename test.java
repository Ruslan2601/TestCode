package com.javarush.task.task14.task1411;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class test {
    public static void main(String[] args) {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int numberOfLines;
        String cityLine;
        ArrayList<String> cityArray = new ArrayList<>();
        try {
            numberOfLines = Integer.parseInt(reader.readLine());
            ArrayList<String> cities = new ArrayList<>();
            for (int i = 0; i < numberOfLines; i++) {
                cityLine = reader.readLine();
                String[] strings = cityLine.split(" ");
                if (strings.length != 2 || strings[0].length() < 1 ||
                        strings[1].length() < 1 || strings[0].equals(strings[1])
                        || !strings[0].matches("^[a-zA-Z0-9-]+$") || !strings[1].matches("^[a-zA-Z0-9-]+$")) {
                    break;
                }
                for (String s : strings) {
                    cities.add(s + "");
                }
            }
            int x = 0;
            while (x / 2 != numberOfLines) {
                cityArray.add(cities.get(x));
                String city1 = cities.get(x + 1);
                int y = 0;
                int z = x + 1;
                for (int i = 0; i < numberOfLines; i++) {
                    if (i == 2) {
                        cityArray.add(city1);
                        break;
                    }
                    for (int j = 0; j < cities.size(); j++) {
                        if (j == z) {
                            continue;
                        }
                        if (cities.get(j).equals(city1)) {
                            cityArray.add(cities.get(j));
                            city1 = cities.get(j + 1);
                            z = cities.indexOf(cities.get(j + 1));
                            y++;
                            break;
                        }
                    }
                }
                if (y != numberOfLines - 1) {
                    cityArray.clear();
                } else {
                    break;
                }
                x = x + 2;
            }
        } catch (NumberFormatException e) {
            System.out.println("Enter the number of lines");
        } catch (IOException e) {
            e.printStackTrace();
        }
        for (String s : cityArray) {
            System.out.print(s + " ");
        }
    }
}
