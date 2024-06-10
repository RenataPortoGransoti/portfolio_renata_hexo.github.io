import matplotlib.pyplot as plt
import pandas as pd

# Leia os dados do arquivo CSV
data = pd.read_csv('sorting_times.csv')

# Plotar os resultados
plt.figure(figsize=(10, 6))
for column in data.columns[1:]:
    plt.plot(data['Size'], data[column], label=column)

plt.xlabel('Tamanho do conjunto de entrada')
plt.ylabel('Tempo de execução (ns)')
plt.title('Comparação de Algoritmos de Ordenação')
plt.legend()
plt.grid(True)
plt.show()
